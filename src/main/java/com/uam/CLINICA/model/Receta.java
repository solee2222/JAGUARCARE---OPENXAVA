package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple", members = 
		"numero;"
		+ "sintomatologia;"
		+ "medicamento,cantidad;" +
		"diagnostico;" 
		)
@View(members="anyo,numero;"
		+ "sintomatologia;"
		+ "medicamento,cantidad;"
		+ "diagnostico;")

public class Receta extends Identificable{
	
	@Column(length=4)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	int anyo;
	
	@Column(length=6)
	@DefaultValueCalculator(value=SiguienteNumeroReceta.class,
	properties=@PropertyValue(name="anyo"))
	@ReadOnly
	int numero;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    private Sintomatologia sintomatologia;
    
    @ManyToOne(
    		fetch = FetchType.LAZY,	
    		optional = true)
    @DescriptionsList
    private Medicamento medicamento;

 
    @Required
    private int cantidad;

    @Stereotype("MEMO")
    private String diagnostico;
    
    
    
}