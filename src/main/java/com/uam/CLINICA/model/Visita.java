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
        + "hora_Entrada, hora_Salida, date;"
        + "visitante;"
        + "sintomatologia;"
        + "destino;"
        + "diagnostico;"
        + "medicamentos;"
        + "cantidad_Dispensada;")

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
	
	@Column(length=10)
	@DefaultValueCalculator(HoraCalculador.class)
	private String hora_Entrada;

	@Column(length=10)
	@Required
	private String hora_Salida;
	
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
	@ListProperties("nombre_Comercial, dosis, presentacion, cantidad_Disponible")
	private List<Medicamento> medicamentos;
	    
	private Integer cantidad_Dispensada;
	
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