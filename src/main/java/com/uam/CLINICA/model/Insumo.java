package com.uam.CLINICA.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;
import com.uam.CLINICA.exceptions.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries({
    @NamedQuery(name="Insumo.findByNombre", query="select e from Insumo e where e.nombreInsumo like ?1")
})
public class Insumo extends Identificable{
	
	@PropertyValidator(value= ValidadorInsumo.class)
	@Required(message="Ingrese el nombre del insumo")
	private String nombreInsumo;
	
	@Column(length=200)
	@Required(message="Ingrese la descripci\u00f3n del insumo")
	private String descripcion;
	
	@Column
	@Required(message="Ingrese la cantidad disponible")
	private Integer cantidadDisponible;
	
	@Column
	@Required(message="Ingrese la cantidad m\u00ednima")
	private Integer cantidadMinima;
	
	
	@PrePersist
    @PreUpdate
    public void verificarCantidadMinima() {
        if (cantidadDisponible != null && cantidadMinima != null) {
            if (cantidadDisponible <= cantidadMinima) {
                throw new RefillException(
                        "La cantidad disponible de '" + nombreInsumo + "' est\u00e1 cerca o por debajo de la cantidad m\u00ednima. Rellene."
                );
            }
        }
    }

}
