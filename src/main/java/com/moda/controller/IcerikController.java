package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moda.model.Icerik;
import com.moda.repository.IcerikRepository;

@RestController
@RequestMapping("/api")
public class IcerikController {

	@Autowired
	IcerikRepository repository;

	@GetMapping("/getir/icerik")
	public List<Icerik> getirIcerik() {
		System.out.println("İçerikler  ");
		List<Icerik> icerik= new ArrayList<>();
		repository.findAll().forEach(icerik::add);
		return icerik;
	}

	@PostMapping(value = "/kaydet/icerik")
	public Icerik kaydetIcerik(@RequestBody Icerik icerik) {

		Icerik _icerik = repository.save(new Icerik(icerik.getIcerik(), icerik.getTurId()));
		return _icerik;
	}
	
}