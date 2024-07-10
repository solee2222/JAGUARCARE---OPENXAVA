package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;


@Entity
@Getter
@Setter

@NamedQueries({
	
	@NamedQuery(name="Sintomatologia.findByNombre",query="select e from Sintomatologia e where e.nombre like ?1")
})

public class Sintomatologia extends Identificable{

	@PropertyValidator(value = ValidadorSintoma.class)
	@Required(message="Ingrese el nombre del s\u00edntoma")
	private String nombre;

}
