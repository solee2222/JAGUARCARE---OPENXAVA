package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries({
	@NamedQuery(name="Medicamento.findByNombre",query="select e from Medicamento e where e.nombre like ?1")
})

@View(name="Simple", members="nombre,nombreGenerico;"
		+ "cantidadExistencia;")
public class Medicamento{
	
/*	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificador;*/
	
	//y este
	@Id
	private String id;
	
	@PropertyValidator(value= ValidadorMed.class)
	private String nombre;
	
	private String nombreGenerico;
    
	private Integer cantidadExistencia;
	
/*	@ManyToOne(fetch = FetchType.LAZY)
    @ReferenceView("Simple")
    @NoFrame
    @ReadOnly
    private CompraValidator compraValidator;*/

}