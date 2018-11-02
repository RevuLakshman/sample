package com.btc.kafka.integration.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.btc.kafka.integration.model.Customer;

public interface CustomerRepository extends CassandraRepository<Customer, String> {
 
	@AllowFiltering
	public List<Customer> findByFirstname(String firstname);
 
	@AllowFiltering
	public List<Customer> findByAgeGreaterThan(int age);
}