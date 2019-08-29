package com.moda.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Mesaj")
public class Mesaj{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@Column(name="sohbet_id")
	int sohbetId;
	
	@Column(name="alicikullanici_id")
	int alicikullanici_id;
	

	
	@ManyToOne(optional=false)
	@JoinColumn(name="alicikullanici_id",referencedColumnName="Id",insertable=false, updatable=false)
	private Kullanici alicikullanici;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="gonderenkullanici_id",referencedColumnName="Id",insertable=false, updatable=false)
	private Kullanici gonderenkullanici;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="icerik_id",referencedColumnName="Id",insertable=false, updatable=false)
	private Icerik icerik;
	
	@Column(name = "gorunurluk")
	boolean gorunurluk;
	
	@Column(name = "gonderilmeTarih")
	Date gonderilmeTarih;
	
	@Column(name = "mesaj")
	String mesaj;

	
	public Mesaj(int sohbetId, Kullanici alicikullanici, Kullanici gonderenkullanici, Icerik icerik, String mesaj) {
		super();
		this.alicikullanici = alicikullanici;
	
		this.gonderenkullanici = gonderenkullanici;
		this.icerik = icerik;
		this.mesaj = mesaj;
		this.sohbetId = sohbetId;
	}

	public Mesaj() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getSohbetId() {
		return sohbetId;
	}

	public void setSohbetId(int sohbetId) {
		this.sohbetId = sohbetId;
	}

	public Kullanici getAlicikullanici() {
		return alicikullanici;
	}

	public void setAlicikullanici(Kullanici alicikullanici) {
		this.alicikullanici = alicikullanici;
	}

	public Kullanici getGonderenkullanici() {
		return gonderenkullanici;
	}

	public void setGonderenkullanici(Kullanici gonderenkullanici) {
		this.gonderenkullanici = gonderenkullanici;
	}

	public Icerik getIcerik() {
		return icerik;
	}

	public void setIcerik(Icerik icerik) {
		this.icerik = icerik;
	}

	public boolean isGorunurluk() {
		return gorunurluk;
	}

	public void setGorunurluk(boolean gorunurluk) {
		this.gorunurluk = gorunurluk;
	}

	public Date getGonderilmeTarih() {
		return gonderilmeTarih;
	}

	public void setGonderilmeTarih(Date gonderilmeTarih) {
		this.gonderilmeTarih = gonderilmeTarih;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
}