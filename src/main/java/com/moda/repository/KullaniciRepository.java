package com.moda.repository;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.Kullanici;
import com.moda.util.KullaniciTipi;

public interface KullaniciRepository extends CrudRepository<Kullanici, Long> {
	List<Kullanici> findByKullaniciTipi(KullaniciTipi kullaniciTipi);
	Kullanici save(Kullanici kullanici);
	Kullanici findByEmail(String Email);
	Kullanici findBySifre(String Sifre);
	List<Kullanici> findByDurumAndKullaniciTipi(String durum, com.moda.util.KullaniciTipi kullanici_tipi);
}
