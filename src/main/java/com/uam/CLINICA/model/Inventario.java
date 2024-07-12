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
	"medicamentocomprado, " +
	"cantidadmed_Comprada;")

public class Inventario{
	
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificador;
	
	@Column(length=4)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	int anyo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Medicamento medicamentocomprado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Insumo insumocomprado;
    
	@Required(message="Ingrese la cantidad de medicamento comprada")
	private Integer cantidadmed_Comprada; 
    
	@Required(message="Ingrese la cantidad de insumo comprada")
	private Integer cantidadinsumo_Comprada;
	
}


