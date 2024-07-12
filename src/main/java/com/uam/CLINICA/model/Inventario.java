package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity
@Getter @Setter

public class Inventario extends Identificable {
	
	
	@Column(length=4)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	int anyo;
	
	@Required(message="Ingrese la cantidad de medicamento comprada")
	@Column(name="cantidadmed_comprada")
	private Integer cantidadmedComprada; 
    
	@Required(message="Ingrese la cantidad de insumo comprada")
	@Column(name="cantidadinsumo_comprada")
	private Integer cantidadinsumoComprada;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Medicamento medicamentocomprado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Insumo insumocomprado;
    

}


