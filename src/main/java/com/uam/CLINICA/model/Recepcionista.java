package com.uam.CLINICA.model;

import java.time.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.util.*;
import org.springframework.security.crypto.bcrypt.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries({
    @NamedQuery(name = "Recepcionista.findByCedula", 
                query = "SELECT e FROM Recepcionista e WHERE e.cedula = ?1"),
    @NamedQuery(name="Recepcionista.findByPassword",
	query="select e from Recepcionista e "
			+ "where e.cedula=?1 and e.password=?2"),
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
    
    @Column(length=200)
    @Required(message="Ingrese la contraseña")
    @Password
    @Hidden
    String password;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
 	@ReadOnly
  	@Hidden
 	 public String usuarioDel;
 	
 	@ReadOnly
  	@Hidden
 	 public String usuarioIng;
 	
 	@ReadOnly
  	@Hidden
 	 public String usuarioUpd;
 	
  	@ReadOnly
  	@Hidden
 	 public LocalDate fechaUpd;
  	
  	@ReadOnly
  	@Hidden
 	 public LocalDate fechaIng;
  	

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
        System.out.println("HASH: " + this.password);// Se guarda el hash de la contraseña
    }
    
    public boolean verifyPassword(String rawPassword) {
        return passwordEncoder.matches(rawPassword, this.password);
    }
    
    @PrePersist
 	public void prepersist()
 	{
 		fechaIng = LocalDate.now();
 		usuarioIng = Users.getCurrent();
 		
 		if (!usuarioIng.equals("admin"))
 		{
 			throw new javax.validation.ValidationException(
                    "Usted no puede crear nuevos usuarios. Solicite un usuario al administrador."
            );
 	}}
 	
 	@PreUpdate
 	public void preupdate()
 	{
 		fechaUpd = LocalDate.now();
 		usuarioUpd = Users.getCurrent();
 		if (!usuarioUpd.equals(usuarioIng))
 		{
 			throw new javax.validation.ValidationException(
                    "No puede modificar este usuario porque lo creó otra persona."
            );
 		}

 	}
 	
 	@PreRemove
 	public void preremove()
 	{
 		usuarioDel = Users.getCurrent();
 		System.out.println(LocalDate.now() + " INTENTO DE BORRAR: " + usuarioDel);
 		if (!usuarioDel.equals(usuarioIng))
 		{
 			throw new javax.validation.ValidationException(
                    "No puede eliminar este usuario porque lo creó otra persona."
            );
 		}

 	}

}
