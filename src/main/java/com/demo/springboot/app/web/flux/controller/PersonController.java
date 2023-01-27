package com.demo.springboot.app.web.flux.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.app.web.flux.model.Person;
import com.demo.springboot.app.web.flux.repository.IPersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/people")
public class PersonController {

	private final Logger log = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private IPersonRepository repo;

	@GetMapping
	public Flux<Person> list() {

		return repo.list();
	}

	@GetMapping("/{id}")
	public Mono<Person> listById(@PathVariable Integer id) {

		return repo.listById(id);
	}

	@PostMapping
	public Mono<Person> register(@RequestBody Person per) {

		return repo.registrer(per);
	}

	@PutMapping
	public Mono<Person> change(@RequestBody Person per) {

		return repo.change(per);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable Integer id) {

		return repo.deleteById(id);
	}

}
