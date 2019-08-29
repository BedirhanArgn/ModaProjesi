package com.moda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "IcerikTuru")
public class IcerikTuru implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@Column(name = "turAdi")
	String turAdi;
	

	
	public IcerikTuru() {
		super();
	}


	public IcerikTuru(String turAdi) {
		super();
		this.turAdi = turAdi;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTurAdi() {
		return turAdi;
	}
	public void setTurAdi(String turAdi) {
		this.turAdi = turAdi;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

