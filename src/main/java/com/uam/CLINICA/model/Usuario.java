package com.uam.CLINICA.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries(
		{
			@NamedQuery(name="Usuario.findByPassword",
						query="select e from Usuario e "
								+ "where e.usuario=?1 and e.password=?2")
		}
		)

public class Usuario extends Identificable {

	private String nombre;
	
	private String usuario;
	
	private String password;
	
	/*@OneToMany(mappedBy="usuario")
	@ListProperties("visita.numero,visita.date")
	Collection<Visita> visitas;*/
	

}
