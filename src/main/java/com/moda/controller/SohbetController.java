package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moda.model.Sohbet;
import com.moda.repository.SohbetRepository;

@RestController
@RequestMapping("/api")
public class SohbetController {
	@Autowired
	SohbetRepository repository;

	@GetMapping("/getir/sohbet")
	public List<Sohbet> getirSohbet() {
		System.out.println("Sohbetler");
		List<Sohbet> sohbet = new ArrayList<>();
		repository.findAll().forEach(sohbet::add);
		return sohbet;
	}

	@PostMapping(value = "/kaydet/sohbet")
	public Sohbet kaydetSohbet(@RequestBody Sohbet sohbet) {

		Sohbet _sohbet = repository.save(new Sohbet(sohbet.getGuncellenmeTarihi(), sohbet.getOlusturulmaTarihi()));
		return _sohbet;
	}
}