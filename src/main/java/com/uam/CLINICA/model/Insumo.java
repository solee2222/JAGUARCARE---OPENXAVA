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
	private String nombreInsumo;
	
	@Column
	private String descripcion;
	
	@Column
	private Integer cantidadDisponible;
	
	@Column
	private Integer cantidadMinima;
	
	
	@PrePersist
    @PreUpdate
    public void verificarCantidadMinima() {
        if (cantidadDisponible != null && cantidadMinima != null) {
            if (cantidadDisponible <= cantidadMinima) {
                throw new RefillException(
                        "La cantidad disponible de '" + nombreInsumo + "' está cerca o por debajo de la cantidad mínima. Rellene."
                );
            }
        }
    }

}
