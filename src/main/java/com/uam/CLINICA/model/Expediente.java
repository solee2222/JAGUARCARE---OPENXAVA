package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@View( members = 
//expediente 1 CARPETA CLINICA MEDICA
"CarpetaClinica { " +
"primerApellido; segundoApellido; nombres; unidadLinea; " +
"numeroDeExpediente; numeroINSS; " +
"FechaNacimiento [" +
"diafechaNa; mesfechaNa; aniofechaNa; ]" +
"silais; municipioCarpeta; direccionDomiciliaria; " +
"ultMovi; dosM; unoM; dosA; unoA; diaUni; mesUni; anioUni; unidadCuadro;"+
"}"+

	    
//expediente 2 LISTADO DE PROBLEMAS
"ListaProblemas { " +
	    "fechaPro; numero; nombreProblema;" +
	    "}"+
	    
//expediente 3 CONSTANCIA DE ABANDONO
"ConstanciaAbandono { " +
	    "fechaIngreso; fechaAb; tiempoEstancia; expedienteAb; nombresApellidosUsuario; numeroCedAb; " +
	    "persona; servicivoRef; ellos; personaAbandono; nombrePersonaRetiraUsuario; parentescoAb; "+
	    "}"+
	    
//expediente 4 FORMATO PARA LA REFERENCIA DE PACIENTES
"FormatoReferencia { " +
	    "unidadSalud; servicioRef; expedienteRef; tiposEstablecimiento; nombreApellido;"+
	    "edadReferencia; direccionRef; comunidadRef; municipioRef; departamentoRef;"+
	    "ocupacionReferencia; aseguradoActivo; accidenteTrabajo; comunicacionLlamar; parentescoRef; telefonoRef;"+
	    "empleadorReferencia; numeroSeguro; motivoReferencia; pulso; presionArterial; temperatura; frecRespi; peso; talla; "+
	    "resumenClinico; diagnosticoProblem; fechaEnvio; horaEnvio; acompRef; envioServ;"+
	    "nomMedRef; codMedico; serviRefbajo;"+
	    " }"+
	    
	    
	    
	    //expediente 5 FORMATO PARA LA CONTRAREFERENCIA DE PACIENTES
	    "Contrarreferencia [ " +
	    "contUniSalud; servicioCont; expedienteCont; tipoEstablecimientoCont; nomApCont; " +
	    "edadCont; sexoCont; direccionCont; municipioCont; "
	    + "departCont; ocupCont; asegActCont; llamarCont; parentescoCont; telefCont; emplCont; numSegCont;"
	    + "fechaEgreCont; horaCont; diasCont; diagnostegre; resumenCont; recomCont; paciCont; unidadRefCont;"
	    + "tipoRefCont; noPermitidaCont; nomMedCont;"+
	    " ]"+

	    //expediente 6 NOTAS DE EVOLUCION Y TRATAMIENTO
	    
	    "NotasEvolucionTratamiento [ " +
	    "nomEstbNot; numExpeNot; numCedNotas; nomApNot; fechHorNot; problNot; planes; numPagNot;"+
	    " ]"+
	    
	    //expediente 7 NOTAS DE ENFERMERIA
	    
	    "NotasEnfermeria [ " +
	    "enfNomEstbNot; enfNumExpeNot; enfNumCedNotas; enfNomApNot; enfFechHorNot; enfObservNot; enfPlanes; enfNumPagNot;"+
	    " ]"+
	    
	    //expediente 8 HISTORIA CLINICA - en proceso
	    
	    "Identificacion { " +
	    "histClic; numExpClic; nomClic; nacimiClic; numCarnetClic; civilClic; sexoClic; tipoClic; lugarNacClic;"
	    + "residenClic; colabClic; dirClic; ciudadClic; ocupaClic; escolaClic; razaClic; religClic"+
	    " }, " +
	    "AntecedentesFamiliares { " +
	    "sonClic;"+
	    " }"+

	   //expediente 9 Consentimiento informado
	   
	   //expediente 10 HOJA DE IDENTIFICACION DE USUARIOS
	    "HojaIdentificaciónUsuarios [ " +
    "establecimientoSalud; nombreUsuario; numeroCedula; etnia; " +
    "fecha; fechaNacimiento; edad;" +
    "escolaridad; ocupacion; direccionResidencia; " +
    "localidad; municipio; departamento; " +
    "responsableEmergencia; estadoCivil; telefonos; parentesco; direccion; " +
    "empleador; direccionEmpleador; numeroAsegurado; actualizacionDirecciones" +
" ]"
    //expediente 11 REPORTE DE LABORATORIO CLINICO Y MEDIOS DIAGNOSTICOS

)
@Getter @Setter

public class Expediente extends Identificable{
	
	//Expediente 1 Carpeta Clinica Medica
	
	@Column(length = 50)
    private String primerApellido;
    
    @Column(length = 50)
    private String segundoApellido;
    
    @Column(length = 50)
    private String nombres;

    @Column(length = 50)
    private String unidadLinea;

    @Column(length = 50)
    private String numeroDeExpediente;

    @Column(length = 20)
    private String numeroINSS;

    @Column(length = 2)
    private Integer diafechaNa;
    @Column(length = 2)
    private Integer mesfechaNa;
    @Column(length = 4)
    private Integer aniofechaNa;

    @Column(length = 50)
    private String silais;

    @Column(length = 20)
    private String municipioCarpeta;
    
    @Column(length = 300)
    private String direccionDomiciliaria;
    
    @Column(length = 8)
    private String ultMovi;

    @Column(length = 8)
    private String dosM;

    @Column(length = 8)
    private String unoM;

    @Column(length = 8)
    private String dosA;

    @Column(length = 8)
    private String unoA;

    @Column(length = 8)
    private String diaUni;

    @Column(length = 8)
    private String mesUni;

    @Column(length = 8)
    private String anioUni;

    @Column(length = 8)
    private String unidadCuadro;

	//Expediente 2 LISTA DE PROBLEMAS
    
    @Column(length = 255)
    @Temporal(TemporalType.DATE)
    private Date fechaPro;

    @Column(length = 255)
    private Integer numero;

    @Column(length = 255)
    private String nombreProblema;
/*
    @Enumerated(EnumType.STRING)
    @Column(length = 255)
    private CondicionProblema condicion;

    public enum CondicionProblema {
        INACTIVO, RESUELTO
    }*/
    
  //Expediente 3 COSNTANCIA DE ABANDONO
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @Temporal(TemporalType.DATE)
    private Date fechaAb;
    
    @Column(length = 255)
    private String tiempoEstancia;

    @Column(length = 20)
    private String expedienteAb;

    @Column(length = 255)
    private String nombresApellidosUsuario;

    @Column(length = 20)
    private String numeroCedAb;

    @Column(length = 255)
    private String persona;

    @Column(length = 100)
    private String servicivoRef;

    @Column(length = 255)
    private String ellos;

    @Column(length = 255)
    private String personaAbandono;

    @Column(length = 255)
    private String nombrePersonaRetiraUsuario;

    @Column(length = 50)
    private String parentescoAb;
   
    
   //expediente 4 FORMATO PARA LA REFERENCIA DE PACIENTES
    
    @Column(length = 100)
    private String unidadSalud;
    
    @Column(length = 100)
    private String servicioRef;
    
    @Column(length = 20)
    private String expedienteRef;
    
    @Column(length = 100)
    private String tiposEstablecimiento; // Publico, Privado
    
    @Column(length = 255)
    private String nombreApellido;
    
    @Column(length = 3)
    private Integer edadReferencia;
    
    @Column(length = 255)
    private String direccionRef;
    
    @Column(length = 100)
    private String comunidadRef;
    
    @Column(length = 100)
    private String municipioRef;
    
    @Column(length = 100)
    private String departamentoRef;
    
    @Column(length = 100)
    private String ocupacionReferencia;
    
    @Column(nullable = false)
    private Boolean aseguradoActivo;
    
    @Column(nullable = false)
    private Boolean accidenteTrabajo;
    
    @Column(length = 100)
    private String comunicacionLlamar;
    
    @Column(length = 50)
    private String parentescoRef;
    
    @Column(length = 20)
    private String telefonoRef;
    
    @Column(length = 100)
    private String empleadorReferencia;
    
    @Column(length = 20)
    private String numeroSeguro;
    
    @Column(length = 255)
    private String motivoReferencia;
    
    @Column(length = 10)
    private String pulso;
    
    @Column(length = 50)
    private String presionArterial;
    
    @Column(length = 10)
    private String temperatura;
    
    @Column(length = 10)
    private String frecRespi;
    
    @Column(length = 10)
    private String peso;
    
    @Column(length = 10)
    private String talla;
    
    @Column(length = 2048)  
    private String resumenClinico;
    
    @Column(length = 255)
    private String diagnosticoProblem;
    
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    
    @Temporal(TemporalType.TIME)
    private Date horaEnvio;
    
    @Column(length = 100)
    private String acompRef;
    
    @Column(length = 100)
    private String envioServ;
    
    @Column(length = 255)
    private String nomMedRef;  // Nombre del médico referente
    
    @Column(length = 50)
    private String codMedico;  // Código del médico
    
    @Column(length = 100)
    private String serviRefbajo;

    /*
    public enum TipoAsegurado {
        COTIZANTE, BENEFICIARIO
    }
    
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TipoAsegurado tipoAsegurado;  // Enum for Cotizante, Beneficiario
    
    public String getTipoAsegurado() {
        return this.tipoAsegurado.name();
    }

    public enum TipoReferencia {
        URGENTE, NO_URGENTE
    }
    
    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TipoReferencia tiposRef;  // Enum for Urgente, No urgente
   
    public String getTipoReferencia() {
        return this.tiposRef.name();
    }*/
    

  //expediente 5 FORMATO PARA LA CONTRAREFERENCIA DE PACIENTES
    
    @Column(length = 100)
    private String contUniSalud;
    @Column(length = 100)
    private String servicioCont;
    @Column(length = 20)
    private String expedienteCont;
    @Column(length = 50)
    private String tipoEstablecimientoCont;
    @Column(length = 255)
    private String nomApCont;
    @Column(length = 10)
    private String edadCont;
    @Column(length = 10)
    private String sexoCont;
    @Column(length = 255)
    private String direccionCont;
    @Column(length = 100)
    private String municipioCont;
    @Column(length = 100)
    private String departCont;
    @Column(length = 100)
    private String ocupCont;
    @Column(length = 10)
    private String asegActCont;
    @Column(length = 255)
    private String llamarCont;
    @Column(length = 50)
    private String parentescoCont;
    @Column(length = 20)
    private String telefCont;
    @Column(length = 100)
    private String emplCont;
    @Column(length = 20)
    private String numSegCont;
    @Temporal(TemporalType.DATE)
    private Date fechaEgreCont;
    @Column(length = 10)
    private String horaCont;
    @Column(length = 10)
    private String diasCont;
    @Column(length = 255)
    private String diagnostegre;
    @Column(length = 2048)
    private String resumenCont;
    @Column(length = 2048)
    private String recomCont;
    @Column(length = 100)
    private String paciCont;
    @Column(length = 100)
    private String unidadRefCont;
    @Column(length = 50)
    private String tipoRefCont;
    @Column(length = 255)
    private String noPermitidaCont;
    @Column(length = 100)
    private String nomMedCont;

  //expediente 6 NOTAS DE EVOLUCION Y TRATAMIENTO
    
    @Column(length = 100)
    private String nomEstbNot;
    @Column(length = 20)
    private String numExpeNot;
    @Column(length = 20)
    private String numCedNotas;
    @Column(length = 255)
    private String nomApNot;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechHorNot;
    @Column(length = 2048)
    private String problNot;
    @Column(length = 2048)
    private String planes;
    @Column(length = 10)
    private String numPagNot;

  //expediente 7 NOTAS DE ENFERMERIA

    @Column(length = 100)
    private String enfNomEstbNot;
    @Column(length = 20)
    private String enfNumExpeNot;
    @Column(length = 20)
    private String enfNumCedNotas;
    @Column(length = 255)
    private String enfNomApNot;
    @Temporal(TemporalType.TIMESTAMP)
    private Date enfFechHorNot;
    @Column(length = 2048)
    private String enfObservNot;
    @Column(length = 2048)
    private String enfPlanes;
    @Column(length = 10)
    private String enfNumPagNot;

    //expediente 8 HISTORIA CLINICA - en proceso
    @Column(length = 100)
    private String histClic;
    @Column(length = 20)
    private String numExpClic;
    @Column(length = 255)
    private String nomClic;
    @Temporal(TemporalType.DATE)
    private Date nacimiClic;
    @Column(length = 20)
    private String numCarnetClic;
    @Column(length = 50)
    private String civilClic;
    @Column(length = 10)
    private String sexoClic;
    @Column(length = 50)
    private String tipoClic;
    @Column(length = 100)
    private String lugarNacClic;
    @Column(length = 255)
    private String residenClic;
    @Column(length = 100)
    private String colabClic;
    @Column(length = 255)
    private String dirClic;
    @Column(length = 100)
    private String ciudadClic;
    @Column(length = 100)
    private String ocupaClic;
    @Column(length = 100)
    private String escolaClic;
    @Column(length = 50)
    private String razaClic;
    @Column(length = 50)
    private String religClic;
    @Column(length = 2048)
    private String sonClic;

    
	//Expediente 10 HOJA IDENTIFICACION DE USUARIOS
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
    
    /*public enum Sexo {
        M, F
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Sexo sexo; // M or F
    
    public String getSexoAsString() {
        return this.sexo.name();
    }¨/

/*
    public enum Categoria {
        COTIZANTE, CONYUGE, HIJO, JUBILADO
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Categoria categoria;  // Usando enum aquí

    public String getCategoriaAsString() {
        return this.categoria.name();
    }*/

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
    private String telefonos;

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
    
    @Column(length = 100)
    private String estadoCivil;

    @Column(length = 255)
    private String direccionEmpleador;

    @Column(length = 20)
    private String numeroAsegurado;

    @Column(length = 255)
    private String actualizacionDirecciones;

	
}
