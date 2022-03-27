package br.edu.infnet.tp3Nuvem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Tp3NuvemApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp3NuvemApplication.class, args);
	}

}
