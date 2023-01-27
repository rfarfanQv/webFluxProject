package com.demo.springboot.app.web.flux.repository;


import com.demo.springboot.app.web.flux.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonRepository {
	
	
	Mono<Person> registrer(Person per);
	Mono<Person> change(Person per);
	Flux<Person> list();
	Mono<Person> listById(Integer id);
	Mono<Void> deleteById(Integer id);
	
	

}
