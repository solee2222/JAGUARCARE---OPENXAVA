package com.uam.CLINICA.model;

import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Embeddable
@Getter @Setter
public class Compra{
	
	private int numCompra;

	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	private LocalDate fecha;
	
	
	//este id con 
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@DescriptionsList
	private Medicamento medicamento;
	
	private Date lote;

	private Date vencimiento;

    @Column(length = 35)
    private String presentacion;

    @Stereotype("MEMO")
    private String indicaciones;
	
	private int cantidad;
	
	@ManyToOne
	@DescriptionsList
	private Proveedor proveedor;

	
}
