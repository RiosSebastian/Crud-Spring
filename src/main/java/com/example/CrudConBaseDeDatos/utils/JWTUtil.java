package com.example.CrudConBaseDeDatos.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
@Service
public class JWTUtil {

    @Value("${security.jwt.secret:defaultSecret}")
    private String key;

    @Value("${security.jwt.issuer:defaultIssuer}")
    private String issuer;

    @Value("${security.jwt.ttlMillis:3600000}")
    private long ttlMillis;

    private final Logger log = LoggerFactory.getLogger(JWTUtil.class);

    public String create(String id, String subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        byte[] apiKeySecretBytes = Base64.getDecoder().decode(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    public String getValue(String jwt) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Base64.getDecoder().decode(key))
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            return claims.getSubject();
        } catch (ExpiredJwtException e) {
            log.error("Token expirado");
            return null; // O lanzar una excepción personalizada
        } catch (JwtException e) {
            log.error("Token inválido: " + e.getMessage());
            return null;
        }
    }

    public String getKey(String jwt) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Base64.getDecoder().decode(key))
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            return claims.getId();
        } catch (JwtException e) {
            log.error("Token inválido: " + e.getMessage());
            return null;
        }
    }
}
