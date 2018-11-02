package com.btc.kafka.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.btc.kafka.integration.model.Customer;
import com.btc.kafka.integration.repository.CustomerRepository;

@SpringBootApplication
public class KafkaZookeeperIntegrationApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaZookeeperIntegrationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		clearData();
		saveData();
		lookup();
	}
	public void clearData(){
		customerRepository.deleteAll();
	}
	
	public void saveData(){
		System.out.println("===================Save Customers to Cassandra===================");
		Customer cust_1 = new Customer(1, "Peter", "Smith", 20);
        Customer cust_2 = new Customer(2, "Mary", "Taylor", 25);
        Customer cust_3 = new Customer(3, "Peter", "Brown", 30);
        Customer cust_4 = new Customer(4, "Lauren", "Taylor", 20);
        Customer cust_5 = new Customer(5, "Lauren", "Flores", 45);
        Customer cust_6 = new Customer(6, "Peter", "Williams", 20);
 
        // save customers to ElasticSearch
        customerRepository.save(cust_1);
        customerRepository.save(cust_2);
        customerRepository.save(cust_3);
        customerRepository.save(cust_4);
        customerRepository.save(cust_5);
        customerRepository.save(cust_6);
	}
	
	public void lookup(){
		System.out.println("===================Lookup Customers from Cassandra by Firstname===================");
		List<Customer> peters = customerRepository.findByFirstname("Peter");
		peters.forEach(System.out::println);
 
		System.out.println("===================Lookup Customers from Cassandra by Age===================");
		List<Customer> custsAgeGreaterThan25 = customerRepository.findByAgeGreaterThan(25);
		custsAgeGreaterThan25.forEach(System.out::println);
		System.out.println("=============== End =================");
	}
	
	
	
}
