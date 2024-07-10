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
	@Required(message="Ingrese el nombre comercial del medicamento")
	private String nombreComercial;
	@Column
	@Required(message="Ingrese el nombre gen\u00e9rico del medicamento")
    private String nombreGenerico;
    @Column
    @Required(message="Ingrese la dosis")
    private String dosis;
    
    @Enumerated(EnumType.STRING)
    private PresentacionMedicamento presentacion;
    @Column
    @Required(message="Ingrese el lote del medicamento")
	private String lote;
    @Column
	@Required(message="Ingrese la fecha de vencimiento")
    private Date vencimiento;
    @Column(length=200)
	@Required(message="Ingrese las indicaciones")
    private String indicaciones;
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
                        "La cantidad disponible de '" + nombreComercial + "' est\u00e1 cerca o por debajo de la cantidad m\u00ednima. Rellene."
                );
            }
        }
    }


}