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
	
	@Column(name="cantidadmed_comprada")
	private Integer cantidadmedComprada; 
    
	@Column(name="cantidadinsumo_comprada")
	private Integer cantidadinsumoComprada;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Medicamento medicamentocomprado;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Insumo insumocomprado;
    
    @PrePersist
    @PreUpdate
    private void actualizarMedicamentoDisponible() throws Exception {
        if (cantidadmedComprada != null && medicamentocomprado != null) {
            int nuevaCantidad = medicamentocomprado.getCantidadDisponible() + cantidadmedComprada;
            medicamentocomprado.setCantidadDisponible(nuevaCantidad);
        }
        
        if (cantidadinsumoComprada != null && insumocomprado != null) {
            int nuevaCantidadInsumo = insumocomprado.getCantidadDisponible() + cantidadinsumoComprada;
            insumocomprado.setCantidadDisponible(nuevaCantidadInsumo);
        }
        
    }
    
}


