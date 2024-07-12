package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import com.uam.CLINICA.exceptions.*;

import lombok.*;

@Entity
@Getter @Setter
/*@NamedQueries({
	@NamedQuery(name="Medicamento.findByNombre",query="select e from Medicamento e where e.nombre like ?1")
})*/

@Views({
    @View(name="VistaVisita", members="nombreComercial, dosis, presentacion, cantidad_Disponible")
})
public class Medicamento {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
	
	@Column(name = "nombre_comercial")
	//@PropertyValidator(value= ValidadorMed.class)
	private String nombreComercial;
	@Column(name = "nombre_generico")
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
    @Column(name="cantidad_disponible")
    private Integer cantidad_Disponible;

	@Column(name="cantidad_minima")
	private Integer cantidad_Minima;
	
    public void verificarCantidadMinima() {
        if (cantidad_Disponible != null && cantidad_Minima != null) {
            if (cantidad_Disponible <= cantidad_Minima) {
                throw new RefillException(
                        "La cantidad disponible de '" + nombreComercial + "' está cerca o por debajo de la cantidad mínima. Rellene."
                );
            }
        }
    }


}