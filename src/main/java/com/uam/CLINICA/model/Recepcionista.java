package com.uam.CLINICA.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries(
		{
			@NamedQuery(name="Recepcionista.findByPassword",
						query="select e from Recepcionista e "
								+ "where e.Cedula=?1 and e.password=?2")
		}
		)

public class Recepcionista{

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //Universally unique identifier
	@Column(length=10)
    @Hidden
    private String idRecepcionista;
	
	
    @Column(length = 50)
    String Cedula;
    
    @Column(length=50)
    String name;
    
    @Hidden
    String password;



}
