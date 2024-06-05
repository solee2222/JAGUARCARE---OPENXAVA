package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter @Setter
public class Expediente extends Identificable{
	@Column(length = 100)
    private String establecimientoSalud;

    @Column(length = 100)
    private String nombreUsuario;

    @Column(length = 20)
    private String numeroCedula;

    @Column(length = 50)
    private String etnia;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(length = 10)
    private String edad;

    @Column(length = 1)
    private String sexo;  // M or F

    @Column(length = 50)
    private String categoria;  // Options: Cotizante, Cónyuge, Hijo, Jubilado

    @Column(length = 100)
    private String escolaridad;

    @Column(length = 100)
    private String ocupacion;

    @Column(length = 255)
    private String direccionResidencia;

    @Column(length = 100)
    private String localidad;

    @Column(length = 100)
    private String municipio;

    @Column(length = 100)
    private String departamento;

    @Column(length = 100)
    private String responsableEmergencia;

    @Column(length = 50)
    private String parentesco;

    @Column(length = 255)
    private String direccion;

    @Column(length = 100)
    private String empleador;

    @Column(length = 255)
    private String direccionEmpleador;

    @Column(length = 20)
    private String numeroAsegurado;

    @Column(length = 255)
    private String actualizacionDirecciones;

    @Column(length = 100)
    private String nombreFirmaPersonalAdmision;
	
}
