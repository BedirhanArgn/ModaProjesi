package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moda.model.Mesaj;
import com.moda.repository.MesajRepository;

@RestController
@RequestMapping("/api")
public class MesajController {

	@Autowired
	MesajRepository repository;

	@GetMapping("/getir/mesaj")
	public List<Mesaj> getirMesaj() {
		System.out.println("Mesajlar");
		List<Mesaj> mesaj = new ArrayList<>();
		repository.findAll().forEach(mesaj::add);
		return mesaj;
	}

	@PostMapping(value = "/kaydet/mesaj")
	public Mesaj kaydetMesaj(@RequestBody Mesaj mesaj) {

		Mesaj _mesaj = repository.save(new Mesaj( mesaj.getSohbetId(), mesaj.getAlicikullanici(), mesaj.getAlicikullanici(),mesaj.getIcerik(),mesaj.getMesaj()));
		return _mesaj;
	}
	
}
