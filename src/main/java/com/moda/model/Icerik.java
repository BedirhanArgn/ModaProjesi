package com.moda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Icerik")
public class Icerik implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="icerikTurId",referencedColumnName="Id")
	private IcerikTuru turId; 
	
	@Column(name = "icerik")
	String icerik;
	

	public Icerik() {
		super();
	}

	public Icerik(String icerik, IcerikTuru turId ) {
		super();
		this.icerik = icerik;
		this.turId = turId;
	}

	public int getIcerikId() {
		return id;
	}

	public void setIcerikId(int id) {
		this.id = id;
	}

	
	public IcerikTuru getTurId() {
		return turId;
	}

	public void setTurId(IcerikTuru turId) {
		this.turId = turId;
	}

	public String getIcerik() {
		return icerik;
	}
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
