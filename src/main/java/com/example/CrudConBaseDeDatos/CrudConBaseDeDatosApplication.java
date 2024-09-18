package com.example.CrudConBaseDeDatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudConBaseDeDatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudConBaseDeDatosApplication.class, args);

		try {
			Thread.sleep(3600000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}


}
