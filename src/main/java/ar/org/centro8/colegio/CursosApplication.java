package ar.org.centro8.colegio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan()	
@SpringBootApplication
public class CursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);

		//Para ejecutar el server en una terminal bash
		//sh mvnw spring-boot:run

	}

}
