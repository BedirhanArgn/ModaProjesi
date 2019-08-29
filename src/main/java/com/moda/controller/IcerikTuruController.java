package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moda.model.IcerikTuru;
import com.moda.repository.IcerikTuruRepository;

@RestController
@RequestMapping("/api")
public class IcerikTuruController {

	@Autowired
	IcerikTuruRepository repository;

	@GetMapping("/getir/icerikturu")
	public List<IcerikTuru> getirIcerikTuru() {
		System.out.println("icerikturu");
		List<IcerikTuru> icerikturu= new ArrayList<>();
		repository.findAll().forEach(icerikturu::add);
		return icerikturu;
	}

	@PostMapping(value = "/kaydet/icerikturu")
	public IcerikTuru kaydetIcerikTuru(@RequestBody IcerikTuru icerikturu) {

		IcerikTuru _icerikturu = repository.save(new IcerikTuru(icerikturu.getTurAdi()));
		return _icerikturu;
	}
	
}