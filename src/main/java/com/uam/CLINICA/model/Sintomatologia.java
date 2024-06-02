package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;


@Entity
@Getter
@Setter

/*@NamedQueries({
	
	@NamedQuery(name="Sintomatologia.findByNombre",query="select e from Sintomatologia e where e.nombre like ?1")
})*/

public class Sintomatologia extends Identificable{

	@PropertyValidator(value = ValidadorSintoma.class)
	@Required
	private String nombre;

}
