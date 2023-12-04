package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(name="Simple",members = "nombreProveedor,compania,correo")

public class Proveedor extends Identificable{

    @Column(length = 20)
    @Required
    String nombre;

    @Column(length = 20)
    @Required
    String compania;
    
	@ElementCollection
    @ListProperties("correo")
	private Collection<Correo> correo;


}
