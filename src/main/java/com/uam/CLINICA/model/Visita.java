package com.uam.CLINICA.model;
import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter @Setter

@View(members = "recepcionista;"
        + "anyo, numero;"
        + "horaEntrada, horaSalida, date;"
        + "visitante;"
        + "sintomatologia;"
        + "destino;"
        + "diagnostico;"
        + "medicamento;"
        + "cantidadDispensada;")

public class Visita extends Identificable{
	
	@Column(length=6)
	@DefaultValueCalculator(CurrentYearCalculator.class)
	int anyo;
		
	@Column(length=6)
	@DefaultValueCalculator(value=SiguienteNumeroVisita.class,
	properties=@PropertyValue(name="anyo"))
	@ReadOnly
	int numero;
	
	@ManyToOne(fetch = FetchType.LAZY,
			optional = false)
	@DescriptionsList
    private Recepcionista recepcionista;
	
	@Column(length=10)
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	private LocalDate date; 
	
	@Column(name="hora_entrada")
	@DefaultValueCalculator(HoraCalculador.class)
	private String horaEntrada;

	@Column(name="hora_salida")
	@Required
	private String horaSalida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@ReferenceView("Simple")
    private Visitante visitante;

	@ManyToOne(fetch=FetchType.LAZY, optional = true)
	@DescriptionsList(descriptionProperties = "nombre")
	private Sintomatologia sintomatologia; 
	     
	@Enumerated(EnumType.STRING)
	private Destino destino;
	    
	private String diagnostico;
	
	@Column(name="cantidad_dispensada")
	private Integer cantidadDispensada;
	    
	@ManyToMany(fetch=FetchType.LAZY)
	@ListProperties("nombreComercial, dosis, presentacion, cantidadDisponible")
	private List<Medicamento> medicamento;
	 
	   
    @PrePersist
    @PreUpdate
    private void actualizarCantidadDisponible() throws Exception {
        if (cantidadDispensada != null && medicamento != null && !medicamento.isEmpty()) {
            for (Medicamento med : medicamento) {
                int nuevaCantidad = med.getCantidadDisponible() - cantidadDispensada;
                if (nuevaCantidad < 0) {
                    throw new javax.validation.ValidationException(
                            "La cantidad dispensada no puede ser mayor que la cantidad disponible."
                    );
                }
                med.setCantidadDisponible(nuevaCantidad);
            }
        }
    }

}