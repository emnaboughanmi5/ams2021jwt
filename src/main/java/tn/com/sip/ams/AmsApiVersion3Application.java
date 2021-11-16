package tn.com.sip.ams;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import tn.com.sip.ams.controllers.ProviderController;

@SpringBootApplication
public class AmsApiVersion3Application  extends SpringBootServletInitializer{
	public static void main(String[] args) {
	  //  new File(ProviderController.uploadDirectory).mkdir();
		SpringApplication.run(AmsApiVersion3Application.class, args);
	}

}
