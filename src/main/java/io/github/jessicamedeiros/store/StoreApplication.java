package io.github.jessicamedeiros.store;

import io.github.jessicamedeiros.store.enums.ClientType;
import io.github.jessicamedeiros.store.enums.PaymentStatus;
import io.github.jessicamedeiros.store.model.*;
import io.github.jessicamedeiros.store.model.payment.Order;
import io.github.jessicamedeiros.store.model.payment.Payment;
import io.github.jessicamedeiros.store.model.payment.PaymentByBoleto;
import io.github.jessicamedeiros.store.model.payment.PaymentByCard;
import io.github.jessicamedeiros.store.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}
}
