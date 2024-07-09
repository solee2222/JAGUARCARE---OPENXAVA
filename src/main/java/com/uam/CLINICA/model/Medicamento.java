package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;
import com.uam.CLINICA.exceptions.*;

import lombok.*;

@Entity
@Getter @Setter
@NamedQueries({
    @NamedQuery(name="Medicamento.findByNombre", query="select e from Medicamento e where e.nombreComercial like ?1") //valida el nombre del medicamento comercial
})

@Views({
    @View(name="VistaVisita", members="nombreComercial, dosis, presentacion, cantidadDisponible")
})
public class Medicamento extends Identificable{

	
	@PropertyValidator(value= ValidadorMed.class)
	private String nombreComercial;
	@Column
    private String nombreGenerico;
    @Column
    private String dosis;
    
    @Enumerated(EnumType.STRING)
    private PresentacionMedicamento presentacion;
    @Column
	private String lote;
    @Column
    private Date vencimiento;
    @Column
    private String indicaciones;
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
                        "La cantidad disponible de '" + nombreComercial + "' está cerca o por debajo de la cantidad mínima. Rellene."
                );
            }
        }
    }


}