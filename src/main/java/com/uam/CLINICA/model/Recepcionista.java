package com.uam.CLINICA.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries(
		{
			@NamedQuery(name="Recepcionista.findByPassword",
						query="select e from Recepcionista e "
								+ "where e.cedula=?1 and e.password=?2"),
		    @NamedQuery(name="Recepcionista.findByCedula",
            			query="SELECT e FROM Recepcionista e WHERE e.cedula = ?1"),
		    @NamedQuery(name="Recepcionista.findByName",
            			query="SELECT e FROM Recepcionista e WHERE e.name = ?1")
		}
		)
@Views({
    @View(members="name, cedula; password;")
})

public class Recepcionista{

	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //Universally unique identifier
	@Column(length=40)
    @Hidden
    private String idRecepcionista;
	
    @Column(length = 50)
    @PropertyValidator(value= ValidadorCedRecepcionista.class)
    @Required(message="Ingrese la c\u00e9dula")
    String cedula;
    
    @Column(length=50)
    @PropertyValidator(value= ValidadorNomRecepcionista.class)
    @Required(message="Ingrese el nombre")
    String name;
    
    @Column(length=50)
    @Required(message="Ingrese la contraseña")
    String password;



}
