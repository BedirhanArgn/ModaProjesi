package com.moda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class KullaniciTarzController {

//	@Autowired
//	KullaniciTarzRepositoy repository;
//
//	@GetMapping("/getir/kullanicitarz")
//	public List<KullaniciTarz> getirKullaniciTarz() {
//		System.out.println("KullaniciTarzlar");
//		List<KullaniciTarz> KullaniciTarz = new ArrayList<>();
//		repository.findAll().forEach(KullaniciTarz::add);
//		return KullaniciTarz;
//	}
//
//	@PostMapping(value = "/kaydet/kullanicitarz")
//	public KullaniciTarz kaydetKullaniciTarz(@RequestBody KullaniciTarz kullanicitarz) {
//
//		KullaniciTarz _kullanicitarz = repository.save(new KullaniciTarz(kullanicitarz.getktID(), kullanicitarz.getkullaniciID(), kullanicitarz.gettarzID()));
//		return _kullanicitarz;
//	}
//	
}
