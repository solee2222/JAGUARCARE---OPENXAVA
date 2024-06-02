package com.uam.CLINICA.model;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members=
	"anyo, " + 
	"medicamentoComprado, " +
	"cantidadComprada;")

public class Inventario{
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificador;
	
	private int id;
	
	@Column(length=4)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	int anyo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Medicamento medicamentoComprado; 
    
	private Integer cantidadComprada; 
    
	
}

