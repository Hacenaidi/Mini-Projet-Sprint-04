package com.hacen.evenements.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;
	
	
	
	
	@Size (min = 2,max = 15)
	private String nomEvenement;
	
	
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double capacite;
	
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent 
	private Date dateEvenement;
	
	
	
	@ManyToOne
	private Type type;
	
	
	
	public Evenement() {
		super();
		
	}
	
	public Evenement(String nomEvenement, Double capacite, Date dateEvenement) {
		super();
		this.nomEvenement = nomEvenement;
		this.capacite = capacite;
		this.dateEvenement = dateEvenement;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getIdEvenement() {
		return idEvenement;
	}
	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}
	public String getNomEvenement() {
		return nomEvenement;
	}
	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}
	public Double getCapacite() {
		return capacite;
	}
	public void setCapacite(Double capacite) {
		this.capacite = capacite;
	}
	public Date getDateEvenement() {
		return dateEvenement;
	}
	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	@Override
	public String toString() {
		return "Evenement [idEvenement=" + idEvenement + ", nomEvnement=" + nomEvenement + ", capacite=" + capacite
				+ ", dateEvenement=" + dateEvenement + "]";
	}
	
	
}
