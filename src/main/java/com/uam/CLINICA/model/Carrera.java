package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter
@Setter
@NamedQueries({
	@NamedQuery(name="Carrera.findByNombre",query="select e from Carrera e where e.nombre like ?1")
})
public class Carrera extends Identificable{
	
	private String facultad;
	
	@PropertyValidator(value= ValidadorCarrera.class)
	private String nombre;
	
	

}
