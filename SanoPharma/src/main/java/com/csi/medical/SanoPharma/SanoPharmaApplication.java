package com.csi.medical.SanoPharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.csi.controller","com.csi.model","com.csi.dao","com.csi.dao1"})
public class SanoPharmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanoPharmaApplication.class, args);
	}

}
