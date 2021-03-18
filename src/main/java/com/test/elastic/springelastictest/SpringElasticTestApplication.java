package com.test.elastic.springelastictest;

import com.test.elastic.springelastictest.config.ElasticConfiguration;
import org.elasticsearch.client.Client;
import com.test.elastic.springelastictest.model.Users;
import com.test.elastic.springelastictest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class SpringElasticTestApplication {

	@Autowired
	private UserRepository repository;

	@Autowired
	private ElasticConfiguration es;

	@PostMapping("/saveUser")
	public int saveUser(@RequestBody List<Users> users) {
		repository.saveAll(users);
		return users.size();
	}

	@GetMapping("/findAll")
	public Iterable<Users> findAllUsers() {
		return repository.findAll();
	}

	@GetMapping("/findByName/{name}")
	public List<Users> findByName(@PathVariable String name) {
		return repository.findByName(name);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringElasticTestApplication.class, args);
	}






}
