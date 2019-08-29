package com.moda.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.moda.util.KullaniciTipi;

@Entity
@Table(name = "Kullanici")
public class Kullanici {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	Long id;
	
	@Column(name = "Ad")
	String ad;

	@Column(name = "kullanici_tipi")
	@Enumerated(EnumType.STRING)
	private KullaniciTipi kullaniciTipi;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "sifre")
	String sifre;
	
	@Column(name = "telefon")
	String telefon;
	
	@Column(name = "cinsiyet")
	String cinsiyet;
	
   
	@Column(name = "dogum_tarihi")
	@JsonFormat(pattern="yyyy-MM-dd")
	String dogum_tarihi;
	
	@Column(name = "kilo")
	String kilo;
	
	@Column(name = "boy")
	String boy;
	
	@Column(name = "durum")
	String durum;
	
	public Kullanici() {
		super();
	}

	public Kullanici(String ad, String email, String sifre, String telefon, String cinsiyet, String dogum_tarihi,
			String kilo, String boy, KullaniciTipi kullanicitipi ) {
		super();
		this.ad = ad;
		this.email = email;
		this.sifre = sifre;
		this.telefon = telefon;
		this.cinsiyet = cinsiyet;
		this.dogum_tarihi = dogum_tarihi;
		this.kilo = kilo;
		this.boy = boy;
		this.kullaniciTipi = kullanicitipi;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public KullaniciTipi getKullaniciTipi() {
		return kullaniciTipi;
	}

	public void setKullaniciTipi(KullaniciTipi kullaniciTipi) {
		this.kullaniciTipi = kullaniciTipi;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getDogumTarihi() {
		return dogum_tarihi;
	}
	public void setDogumTarihi(String dogum_tarihi) {
		System.out.println(getDogumTarihi());

		this.dogum_tarihi = dogum_tarihi;
	}
	public String getKilo() {
		return kilo;
	}
	public void setKilo(String kilo) {
		this.kilo = kilo;
	}
	public String getBoy() {
		return boy;
	}
	public void setBoy(String boy) {
		this.boy = boy;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
}


