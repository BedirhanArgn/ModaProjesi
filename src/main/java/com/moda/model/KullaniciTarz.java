package com.moda.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "KullaniciTarz")
//public class KullaniciTarz implements Serializable{
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ktID")
//	int ktID;
//	
//	@OneToOne(optional=false)
//	@JoinColumn(name="kullanici_id",referencedColumnName="Id", insertable=false, updatable=false)
//	private Kullanici kullanici; 
//	
//	@OneToOne(optional=false)
//	@JoinColumn(name="tarz_id",referencedColumnName="tarzId", insertable=false, updatable=false)
//	private Tarz tarz; 
//	
//	public KullaniciTarz() {
//		super();
//	}
//
//	public int getKtID() {
//		return ktID;
//	}
//
//	public void setKtID(int ktID) {
//		this.ktID = ktID;
//	}
//
//	public Kullanici getKullanici() {
//		return kullanici;
//	}
//
//	public void setKullanici(Kullanici kullanici) {
//		this.kullanici = kullanici;
//	}
//
//	public Tarz getTarz() {
//		return tarz;
//	}
//
//	public void setTarz(Tarz tarz) {
//		this.tarz = tarz;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//
//	
//}
