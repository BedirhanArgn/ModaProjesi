package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.moda.model.Yorum;
import com.moda.repository.YorumRepository;

public class YorumController {
	@Autowired
	YorumRepository repository;

	@GetMapping("/getir/yorum")
	public List<Yorum> getAllCustomers() {
		System.out.println("Yorumlar");
		List<Yorum> Yorum = new ArrayList<>();
		repository.findAll().forEach(Yorum::add);
		return Yorum;
	}

	@PostMapping(value = "/yorum/olustur")
	public Yorum postCustomer(@RequestBody Yorum Yorum) {

		Yorum _customer = repository.save(new Yorum(Yorum.getId(),Yorum.getkullaniciID(),Yorum.getyorumIcerik()));
		return _customer;
	}

}
