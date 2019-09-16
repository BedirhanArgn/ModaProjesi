package com.moda.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.moda.model.Kullanici;
import com.moda.repository.KullaniciRepository;
import com.moda.util.KullaniciTipi;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class KullaniciController {
	@Autowired
	KullaniciRepository repository;
	@GetMapping("/getir/kullanici")
	public List<Kullanici> getirKullanici() {
		System.out.println("Kullanıcılar");
		List<Kullanici> kullanici = new ArrayList<>();
		repository.findAll().forEach(kullanici::add);
		return kullanici;
	}
	@PostMapping(value = "/kaydet/kullanici")
	public String kaydetMusteri(@RequestBody Kullanici kullanici, BindingResult bindingResult) {
		Kullanici kul2=repository.findByEmail(kullanici.getEmail());
		String email=kullanici.getEmail();
		if(bindingResult.hasErrors()) {
			return "index";
		}
		else {
			if(kul2!=null) {
				return "index";
			}
			else {
				kullanici.setKullaniciTipi(KullaniciTipi.MUSTERI);
				Kullanici _kullanici = repository.save(kullanici);
				return "index";
			}
		}
	}
	@GetMapping("/getir/modacilistesi")
	public List<Kullanici> getirModaciListesi() {
		List<Kullanici> kullaniciListesi = new ArrayList<>();
		repository.findByKullaniciTipi(KullaniciTipi.MODACI).forEach(kullaniciListesi::add);
		return kullaniciListesi;
	}
	
	@GetMapping("/getir/ProfilGoruntule")
	public Kullanici getirProfil(@RequestParam("id") Long kullaniciID) {
		return repository.findById(kullaniciID).get();
	}
	

	@PostMapping(value = "/guncelle/musteri")
	public Kullanici güncelleMusteri(@RequestBody Kullanici kullanici) {
		kullanici.setKullaniciTipi(KullaniciTipi.MUSTERI);
		Kullanici _kullanici = repository.save(kullanici);
		return _kullanici;
	}
	
	@PostMapping(value = "/guncelle/kullanici")
	public Kullanici güncelleModaci(@RequestBody Kullanici kullanici) {
		kullanici.setKullaniciTipi(KullaniciTipi.MODACI);
		Kullanici _kullanici = repository.save(kullanici);
		return _kullanici;
	}
}