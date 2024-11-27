package com.iset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.iset.dao.CustomerRepository;
import com.iset.entities.Customer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(ConfigParams.class)
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
        	customerRepository.save(new Customer(null, "eni", "contact@eni.tn"));
            customerRepository.save(new Customer(null, "FST", "contact@fst.tn"));
            customerRepository.save(new Customer(null, "ENSI", "contact@ensi.tn"));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
