package com.moda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Yorum")
public class Yorum {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="kullaniciID",referencedColumnName="Id", insertable=false, updatable=false)
	private Kullanici kullaniciID;

	@Column(name = "yorumIcerik")
	String yorumIcerik;
	
	public Yorum() {
	}
	public Yorum( int id, Kullanici kullaniciID, String yorumIcerik) {
		super();
		this.id = id;
		this.kullaniciID = kullaniciID;
		this.yorumIcerik=yorumIcerik;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public Kullanici getkullaniciID() {
		return kullaniciID;
	}

	public void setkullaniciID(Kullanici kullaniciID) {
		this.kullaniciID = kullaniciID;
	}

	public String getyorumIcerik() {
		return yorumIcerik;
	}


	public void setyorumIcerik( String yorumIcerik) {
		this.yorumIcerik = yorumIcerik;
	}
	
	@Override
	public String toString() {
		return "Tarz [yorumID=" + id + ",kullaniciID=\" + kullaniciID + \", yorumIcerik=" + yorumIcerik+ " ]";
	}
}
