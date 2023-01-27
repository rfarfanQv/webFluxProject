package com.demo.springboot.app.web.flux.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.springboot.app.web.flux.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class PersonRepoImpl implements IPersonRepository {

	private final Logger log = LoggerFactory.getLogger(PersonRepoImpl.class);

	@Override
	public Mono<Person> registrer(Person per) {
		log.info(per.toString());
		return Mono.just(per);
	}
	
	@Override
	public Mono<Person> change(Person per) {
		log.info(per.toString());
		return Mono.just(per);
	}

	@Override
	public Flux<Person> list() {
		List<Person> people = new ArrayList<>();
		people.add(new Person(1, "NAME1"));
		people.add(new Person(1, "NAME2"));
		people.add(new Person(1, "NAME3"));
		return Flux.fromIterable(people);
	}

	@Override
	public Mono<Person> listById(Integer id) {
		
		return Mono.just(new Person(id, "MOCK"));
	}

	@Override
	public Mono<Void> deleteById(Integer id) {

		return Mono.empty();
	}

	

}
