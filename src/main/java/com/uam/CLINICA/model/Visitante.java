package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple",members = "primer_Nombre, primer_Apellido")

public class Visitante {
	@Id
	
	private String id;
	
	@Column(length=25)
	private String primer_Nombre;
	
	@Column(length=25)
	private String primer_Apellido;
	
	@Enumerated(EnumType.STRING)
    private Carrera carrera;
    
    @Enumerated(EnumType.STRING)
    private TipoVisitante tipo;

    private String telefono;
	
	/*@OneToMany(mappedBy="visitante")
	@ListProperties("numero,date,receta.diagnostico,receta.sintomatologia.nombre,receta.medicamento.nombre,receta.cantidad")
	Collection<Visita> visitas;*/
	
}
