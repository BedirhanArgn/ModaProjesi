package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moda.model.SilinenSohbet;
import com.moda.repository.SilinenSohbetRepository;

@RestController
@RequestMapping("/api")
public class SilinenSohbetController {
	@Autowired
	SilinenSohbetRepository repository;

	@GetMapping("/getir/silinensohbet")
	public List<SilinenSohbet> getirSilinenSohbet() {
		System.out.println("Silinen Sohbetler");
		List<SilinenSohbet> silinenSohbet = new ArrayList<>();
		repository.findAll().forEach(silinenSohbet::add);
		return silinenSohbet;
	}

	@PostMapping(value = "/kaydet/silinensohbet")
	public SilinenSohbet kaydetSilinenSohbet(@RequestBody SilinenSohbet silinenSohbet) {

		SilinenSohbet _silinenSohbet = repository.save(new SilinenSohbet(silinenSohbet.getSilinmeTarihi()));
		return _silinenSohbet;
	}
}

