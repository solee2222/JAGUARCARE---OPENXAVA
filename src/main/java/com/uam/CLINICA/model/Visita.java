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
        + "medicamentos;"
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
	    
	@ManyToMany(fetch=FetchType.LAZY)
	@ListProperties("nombreComercial, dosis, presentacion, cantidadDisponible")
	private List<Medicamento> medicamentos;
	    
	@Column(name="cantidad_dispensada")
	private Integer cantidadDispensada;
	
    private void checkMedicamentoDisponible() {
    	Medicamento medicine = new Medicamento();
        medicine.verificarCantidadMinima();
    }
	   
/*	@PrePersist
	@PreUpdate
	private void validarHoras() throws Exception {
	    if (horaEntrada != null && horaSalida != null) {
	        LocalTime horaEntradaParsed = LocalTime.parse(this.horaEntrada);
	        LocalTime horaSalidaParsed = LocalTime.parse(this.horaSalida);

	        if (horaSalidaParsed.isBefore(horaEntradaParsed)) {
	            throw new javax.validation.ValidationException(
	                    "La hora de salida debe ser mayor que la hora de entrada."
	            );
	        }
	    }
	} */

}