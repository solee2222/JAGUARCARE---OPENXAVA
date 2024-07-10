package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple",members = "cifID,primerNombre, primerApellido")

public class Visitante extends Identificable{
	
	@Column(length=15)
	@Required(message="Ingrese el CIF o C\u00e9dula del visitante")
	private String cifID;
	
	@Column(length=25)
	@Required(message="Ingrese el primer nombre")
	private String primerNombre;
	
	@Column(length=25)
	@Required(message="Ingrese el primer apellido")
	private String primerApellido;
	
	@Enumerated(EnumType.STRING)
    private Carrera carrera; 
    
    @Enumerated(EnumType.STRING)
    private TipoVisitante tipo;

    @Required(message="Ingrese el tel\u00e9fono")
    private String telefono;
	
	/*@OneToMany(mappedBy="visitante")
	@ListProperties("numero,date,receta.diagnostico,receta.sintomatologia.nombre,receta.medicamento.nombre,receta.cantidad")
	Collection<Visita> visitas;*/
	
}
