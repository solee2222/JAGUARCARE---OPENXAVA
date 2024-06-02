package com.uam.CLINICA.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter @Setter
/*@NamedQueries(
		{
			@NamedQuery(name="Recepcionista.findByPassword",
						query="select e from Recepcionista e "
								+ "where e.recepcionista=?1 and e.password=?2")
		}
		)*/

public class Recepcionista{

    @Id
    String Cedula;
    @Column(length=50)
    String name;
    String password;


}
