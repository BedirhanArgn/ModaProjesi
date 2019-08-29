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
@Table(name = "Sohbet")
public class Sohbet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="kullaniciID",referencedColumnName="Id", insertable=false, updatable=false)
	private Kullanici kullanici; 
	
	@Column(name = "olusturulmaTarihi")
	Date olusturulmaTarihi;
	
	@Column(name = "guncellenmeTarihi")
	Date guncellenmeTarihi;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public Date getOlusturulmaTarihi() {
		return olusturulmaTarihi;
	}

	public void setOlusturulmaTarihi(Date olusturulmaTarihi) {
		this.olusturulmaTarihi = olusturulmaTarihi;
	}

	public Date getGuncellenmeTarihi() {
		return guncellenmeTarihi;
	}

	public void setGuncellenmeTarihi(Date guncellenmeTarihi) {
		this.guncellenmeTarihi = guncellenmeTarihi;
	}

	public Sohbet( Date olusturulmaTarihi, Date guncellenmeTarihi) {
		super();
		this.olusturulmaTarihi = olusturulmaTarihi;
		this.guncellenmeTarihi = guncellenmeTarihi;
	}

	
	
}
