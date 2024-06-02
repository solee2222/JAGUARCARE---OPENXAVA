package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.uam.CLINICA.Calculadores.*;

import lombok.*;

@Entity
@Getter @Setter
/*@NamedQueries({
	@NamedQuery(name="Medicamento.findByNombre",query="select e from Medicamento e where e.nombre like ?1")
})*/

@View(name="Simple", members="nombre,nombreGenerico;"
		+ "cantidadExistencia;")
public class Medicamento extends Identificable{
	
/*	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identificador;*/
	
	//y este
	
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
	
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visita_id")
    private Visita visita;*/

}