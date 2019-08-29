package com.moda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tarz")
public class Tarz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@Column(name = "tarzAdi")
	private String tarzAdi;

	public Tarz() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarzAdi() {
		return tarzAdi;
	}

	public void setTarzAdi(String tarzAdi) {
		this.tarzAdi = tarzAdi;
	}
}