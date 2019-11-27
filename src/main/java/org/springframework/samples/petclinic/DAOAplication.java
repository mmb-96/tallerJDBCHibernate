package org.springframework.samples.petclinic;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.bill.Bill;
import org.springframework.samples.petclinic.persistence.dao.IBillAO;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DAOAplication implements CommandLineRunner{
	
	@Autowired
	IBillAO billDAO;

	
	public static void main(String[] args) {
		SpringApplication.run(DAOAplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Bill b = new Bill();
		b.setIdentificador(954);
		b.setCuantia(4.0);
		b.setFecha_pago(new Date());
		
		billDAO.create(b);
		
	}

}
