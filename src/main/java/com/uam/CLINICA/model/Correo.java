package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Embeddable
@Getter
@Setter
public class Correo {
	
	@PropertyValidator(value = CorreoValidador.class)
	private String correo;

}
