package com.astrie;

import com.astrie.model.Customer;
import com.astrie.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuperMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperMarketApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepo) {
        return args -> {
            Customer customerOne = new Customer("Astrie Uwumviyimana", 20, "astrieuwumviyimana@gmail.com");
            customerRepo.save(customerOne);
        };
    }
}
