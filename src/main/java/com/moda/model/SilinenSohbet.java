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
@Table(name = "SilinenSohbet")
public class SilinenSohbet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="sohbetID",referencedColumnName="Id", insertable=false, updatable=false)
	private Sohbet sohbet; 
	
	@Column(name = "silinmeTarihi")
	Date silinmeTarihi;

	@ManyToOne(optional=false)
	@JoinColumn(name="kullanici_id",referencedColumnName="Id", insertable=false, updatable=false)
	private Kullanici kullanici; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sohbet getSohbet() {
		return sohbet;
	}

	public void setSohbet(Sohbet sohbet) {
		this.sohbet = sohbet;
	}

	public Date getSilinmeTarihi() {
		return silinmeTarihi;
	}

	public void setSilinmeTarihi(Date silinmeTarihi) {
		this.silinmeTarihi = silinmeTarihi;
	}

	public SilinenSohbet( Date silinmeTarihi) {
		super();
		this.silinmeTarihi = silinmeTarihi;
	}
	
}

