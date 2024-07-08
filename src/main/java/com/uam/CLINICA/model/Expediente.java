package com.uam.CLINICA.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@View( members = 
//expediente 1 CARPETA CLINICA MEDICA
"CarpetaClinica { " +
"primerApellido, segundoApellido, nombres;"+
"FechaNacimiento [" +
"diafechaNa, mesfechaNa, aniofechaNa; ]" +
"direccionDomiciliaria; numeroINSS;"+
"unidadLinea; " +
"silais, municipioCarpeta;" +
"ultMovi; dosM; unoM; dosA; unoA; diaUni; mesUni; anioUni; unidadCuadro;"+
"}"+

//expediente 2 LISTADO DE PROBLEMAS
"ListaProblemas { " +
	    "fechaPro, numero; nombreProblema, estadoProblema;"
	    + "nombreProblemaDos,estadoProblemaDos;"
	    + "nombreProblemaTres, estadoProblemaTres;"
	    + "nombreProblemaCuatro, estadoProblemaCuatro;"
	    + "nombreProblemaCinco, estadoProblemaCinco;"
	    + "nombreProblemaSeis, estadoProblemaSeis;"
	    + "nombreProblemaSiete, estadoProblemaSiete;"
	    + "nombreProblemaOcho, estadoProblemaOcho;"
	    + "nombreProblemaNueve,estadoProblemaNueve; " +
	    "}"+
	    
//expediente 3 CONSTANCIA DE ABANDONO
"ConstanciaAbandono { " +
	"expnumero;"
	+ "nombresApellidosUsuario; " +
	"fechaIngreso, horaIngre; " +
	"fechaAb, horaAb;" +
	"tiempoEstancia; " +
	"numeroCedAb; nombreFirmante,responsable;"+
	"servicioSaludRetiro; diagnosticoRazonAbandono; "
	+ "razones;"
	+ "servicioRetiro; " + 
	"responsableUsuario; " +
	"llenarcon ["+
	"nombrePersonaRetiraUsuario; " +
	"parentescoAb; " +
    "]"+
"}"+
	    
//expediente 4 FORMATO PARA LA REFERENCIA DE PACIENTES
"FormatoReferencia { " +
	"expedienteRef;" +
	"unidadSalud,servicioRef; " +
	"tipoEstablecimiento, tipoReferencia;"+
	"nombreApellido,edadReferencia,sexoRef; " +
	"direccionRef,comunidadRef ;" +
	"municipioRef,departamentoRef;"
	+ "ocupacionReferencia; " +
	"aseguradoActivo, tipoAsegurado,accidenteTrabajo;"+
	"comunicacionLlamar; " +
	"parentescoRef,telefonoRef; " +
	"empleadorReferencia,numeroSeguro; " +
	"motivoReferencia; " +
	"pulso,presionArterial,temperatura,frecRespi,peso,talla; " +
	"resumenClinico; " +
	"diagnosticoProblem; " +
	"fechaEnvio,horaEnvio; " +
	"acompRef; " +
	"envioServ,uniRef;"
	+ "silaRef; " +
	"contactoRef; " +
	"nomMedRef; " +
	"serviRefbajo; " +
	"fechaReci,horaReci; " +
"}"+
	    //expediente 5 FORMATO PARA LA CONTRAREFERENCIA DE PACIENTES
	"Contrarreferencia { " +
	    "contUniSalud, expedienteCont;"
	    + "servicioCont, tipoEstablecimientoNuevo;"
	    + "nomApCont,edadCont, sexoCont; " +
	    " direccionCont,comunidadCont;"
	    + "municipioCont,departCont; "
	    + "ocupCont; "
	    + "aseguradoActivoNuevo,tipoAseguradoHis;"
	    + "accidenteTrabajoNuevo,llamarCont;"
	    + "parentescoCont, telefCont; "
	    + "emplCont,numSegCont;"
	    + "uniCont,fechaEgreCont, horaCont; "
	    + "diasCont, diagnostegre;"
	    + "resumenCont;"
	    + "recomCont;"
	    + "paciCont;"
	    + "unidadRefCont;"
	    + "referenciaFue;"
	    + "noPermitidaCont; nomMedCont; "+
	    " }"+

	    //expediente 6 NOTAS DE EVOLUCION Y TRATAMIENTO
	    
"NotasEvolucionTratamiento { " +
	    "nomEstbNot,numExpeNot;"
	    + "nomApNot,numCedNotas;"
	    + "fechHorNot,horaFechaNotUno;problNot; planes; numPagNot;"+
	    " dosNotasEvol[" +
	    "fechaEvoluDos,horaEvoluDos;problemDos; planesDos"+
		"]" +
	    " }"+
	    
	    //expediente 7 NOTAS DE ENFERMERIA
	    
	    "NotasEnfermeria { " +
	    "enfNomEstbNot, enfNumExpeNot; enfNomApNot, enfNumCedNotas;  enfFechHorNot, horaFaltanteEnf; "
	    + "enfObservNot; enfPlanes; enfNumPagNot;"+
	    " dosNotasEnf[" +
	    "fechaDosNotasEnf,horaEnfNota; obserCuidadoEnfDos; planesdosEnf"+
		"]" +
	    " }"+
	    
	    //expediente 8 HISTORIA CLINICA
	    "histoClic { " +
	        "fechaClic,numExpHis;" +
	    
	        "identifiDosClic {" +
	        "nomClic, fechaNaClic; carneClic, estadoClic, sexoHis,tipoPacienteHis;"
	        + "nacClic, residenClic;"
	        + "direCic,ciudadClic;"
	        + "ocupaClic,escolaClic;" +
	        "razaClic, religiClic;    " +
	        "}"+ 
	        
			"antecedenClic {"
			+ "Familia ["
			+ "Vivos  [" +
			"madreEdadHis,madreSana,madreEnfer;"
			+ "padreEdad, padreSano, padreEnfer;"
			+ "hermanoEdad, hermaSnado, hermaEnfer;"
			+ "esposEdad, espoSano, espoEnfe;"+
			"]"
			+ "Muerto  [" +
			 "madreCausa, madreEdadMuer;"
			+ "padreCausa, padreEdadMuer;"
			+ "hermaCausa, hermaEdadMuer;"
			+ "espoCausa, espoEdad;"+

			"]" +
			"]" +
				"hijosHisto;indiCausaClic;"
				+ "numHijoClic; enfermoFalleClic;"
				
				+ "asmaHist,asmaParen;"
				+ "cancerHis,cancerParen;"
				+ "diabetes,diabeteParen;"
				+ "epilep,epilepParen;"
				+ "transmenta,transtorParen;"
				+ "obesidad,obesiParen;"
				+ "cardio,cardioParen;"
				+ "hiperten,hiperParen;"
				+ "sifilis, sifiParen;"
				+ "tuber, tuberParen;"
				+ "nefro,nefroParen;"
				+ "otrosHis,otroParen;" +
			"}" +

	        
	        "identiTresClic {" 
			+ "Trabajo  [" +
			"]" +
	        "promeClic; otroClic; tipoClic; tiempoSustClic; contactClic; " +
	        "tipoContaClic; tiempoContaClic; tipoRuidoClic; tiempoRuidoClic; " +
	        "viveCasaClic; cuartoClic; cantPersClic; ensuCuartoClic; cafe; tabaco; bebiAlco; " +
	        "deport; distracciones; dieta; otroCostum; " +
	        "tipoJornadaHis; sustanciasToxicasHis; radiacionesHis; ruidoHis; " +
	        "medicamentosHis; reposoHis; posicionLaboralHis; " +
	        "}"+ 
	        
	        "antecePatoClic { "+
	        "enfermeInf; inmunizacion;"+
	        "antAlerMed; antAlerCom; antMala; antHepa; antHosp; antOpe; "+
	        "antAsm; antPara; antTuber; antSifi; antGono; antAmig; antTrans; reposoAcciden; tipoRh; "+
	        "}"+
	        
	        "padecimientoAct { "+
	        "motivoConsul; historiaActu;"+
	        "}"+ 
	        
	        "aparatoSis { "+
	        "cardiovas; respirato; digestiv; urogeni; endocri; neuro; organoSenti; sintoGene; gine; psicoso; " +
	        "}"+ 

	        "examenFisico { "+
	        "pesoActu; pesoUnMes; pesoUnAnio; estatu; pulsoUnoDecu; pulsoDosDecu; despuUnoEjer; despuDosEjer; " +
	        "tadecu; sentado; pie; cabeza; craneo; ojos; fdo; nariz; orofaringe; oido; " +
	        "cuello; torax; campleuro; areaPre; axiDer; axiIzq; mamaDer; mamaIzq; abdomen; tr; genita; " +
	        "}"+ 
	        
	        "dorso; miembroSup; pulsoUltiHis; miembroInf; examenNeuro; " +
	    "}"+

	   //expediente 9 CONSENTIMIENTO INFORMADO
	   
	   "Consent { " +
	   "nomLegal; numCedCons; direCasaCons; "
	   + "avisoConsentimiento ["
	   + "nomFamCons; numCedFamCons,numCeluFamCons; direCasaFamCons; "+
       "]"+ 
" }"+

	   //expediente 10 HOJA DE IDENTIFICACION DE USUARIOS
	    "HojaIden { " +
    "numExpHoja,etnia;"
    + "establecimientoSalud,fecha;"
    + "nombreUsuario,fechaNacimiento;"
    + "numeroCedula,edad,sexo; "
    + "categoria,estadoCivil;"
    + "escolaridad,ocupacion;"
    + "direccionResidencia,departamento;"
    + "localidad,telefonos;"
    + "municipio,numeroAsegurado;"
    + "responsableEmergencia;"
    + "parentesco;"
    + "direccion;"
    + "empleador;"
    + "direccionEmpleador;"
    + "actualizacionDirecciones;" +
" }"
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
    
    @Column(length = 400)
    private String direccionDomiciliaria;
    
    @Column(length = 8)
    private String ultMovi;
    
    @Column(length = 8)
    private String diaUni;

    @Column(length = 8)
    private String mesUni;

    @Column(length = 8)
    private String anioUni;

    @Column(length = 8)
    private String unidadCuadro;
    
    //Enums en primer expediente
    
    public enum dosM {
        MARCADO, NO_MARCADO
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 11)
    private dosM dosM; 
    
    public String getDosMAsString() {
        return this.dosM != null ? this.dosM.name() : "Valor por defecto";
    }
    
    public enum unoM {
        MARCADO, NO_MARCADO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 11) 
    private unoM unoM;

    public String getUnoMAsString() {
        return this.unoM != null ? this.unoM.name() : "Valor por defecto";
    }

    public enum dosA {
        MARCADO, NO_MARCADO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 11) 
    private dosA dosA;

    public String getDosAAsString() {
        return this.dosA != null ? this.dosA.name() : "Valor por defecto";
    }
    public enum unoA {
        MARCADO, NO_MARCADO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 11) 
    private unoA unoA;

    public String getUnoAAsString() {
        return this.unoA != null ? this.unoA.name() : "Valor por defecto";
    }

	//Expediente 2 LISTA DE PROBLEMAS
    
    @Column(length = 255)
    private Date fechaPro;

    @Column(length = 20)
    private Integer numero;

    @Column(length = 100)
    private String nombreProblema;
    
    @Column(length = 100)
    private String nombreProblemaDos;

    @Column(length = 100)
    private String nombreProblemaTres;

    @Column(length = 100)
    private String nombreProblemaCuatro;

    @Column(length = 100)
    private String nombreProblemaCinco;

    @Column(length = 100)
    private String nombreProblemaSeis;

    @Column(length = 100)
    private String nombreProblemaSiete;

    @Column(length = 100)
    private String nombreProblemaOcho;

    @Column(length = 100)
    private String nombreProblemaNueve;
    
    public enum estadoProblema { 
    	INACTIVOUno, RESUELTOUno 
    }
    public enum estadoProblemaDos { 
    	INACTIVODos, RESUELTODos 
    }
    public enum estadoProblemaTres { 
    	INACTIVOTres, RESUELTOTres 
    }
    public enum estadoProblemaCuatro { 
    	INACTIVOCuatro, RESUELTOCuatro 
    }
    public enum estadoProblemaCinco { 
    	INACTIVOCinco, RESUELTOCinco 
    }
    public enum estadoProblemaSeis { 
    	INACTIVOSeis, RESUELTOSeis 
    }
    public enum estadoProblemaSiete { 
    	INACTIVOSiete, RESUELTOSiete 
    }
    public enum estadoProblemaOcho { 
    	INACTIVOOcho, RESUELTOOcho 
    }
    public enum estadoProblemaNueve { 
    	INACTIVONueve, RESUELTONueve 
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblema estadoProblema;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaDos estadoProblemaDos;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaTres estadoProblemaTres;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaCuatro estadoProblemaCuatro;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaCinco estadoProblemaCinco;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaSeis estadoProblemaSeis;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaSiete estadoProblemaSiete;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaOcho estadoProblemaOcho;

    @Enumerated(EnumType.STRING)
    @Column(length = 20) 
    private estadoProblemaNueve estadoProblemaNueve;
    
    public String getEstadoProblemaAsString() {
        return this.estadoProblema != null ? this.estadoProblema.name() : "Valor por defecto";
    }

    public String getEstadoProblemaDosAsString() {
        return this.estadoProblemaDos != null ? this.estadoProblemaDos.name() : "Valor por defecto";
    }

    public String getEstadoProblemaTresAsString() {
        return this.estadoProblemaTres != null ? this.estadoProblemaTres.name() : "Valor por defecto";
    }

    public String getEstadoProblemaCuatroAsString() {
        return this.estadoProblemaCuatro != null ? this.estadoProblemaCuatro.name() : "Valor por defecto";
    }

    public String getEstadoProblemaCincoAsString() {
        return this.estadoProblemaCinco != null ? this.estadoProblemaCinco.name() : "Valor por defecto";
    }

    public String getEstadoProblemaSeisAsString() {
        return this.estadoProblemaSeis != null ? this.estadoProblemaSeis.name() : "Valor por defecto";
    }

    public String getEstadoProblemaSieteAsString() {
        return this.estadoProblemaSiete != null ? this.estadoProblemaSiete.name() : "Valor por defecto";
    }

    public String getEstadoProblemaOchoAsString() {
        return this.estadoProblemaOcho != null ? this.estadoProblemaOcho.name() : "Valor por defecto";
    }

    public String getEstadoProblemaNueveAsString() {
        return this.estadoProblemaNueve != null ? this.estadoProblemaNueve.name() : "Valor por defecto";
    }

    
    
  //Expediente 3 COSNTANCIA DE ABANDONO
    
    @Column(length = 10)
    private Integer expnumero;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaAb;
    @Column(length = 33)
    private String horaAb;
    @Column(length = 33)
    private String horaIngre;
    
    @Column(length = 20)
    private String tiempoEstancia;

    @Column(length = 255)
    private String nombresApellidosUsuario;

    @Column(length = 20)
    private String numeroCedAb;
    
    @Column(length = 20)
    private String nombreFirmante;
    
    
    @Column(length = 30)
    private String servicioSaludRetiro;
    
    @Column(length = 200)
    private String diagnosticoRazonAbandono;
    
    @Column(length = 200)
    private String razones;
    
    @Column(length = 20)
    private String responsableUsuario;
   
    @Column(length = 255)
    private String nombrePersonaRetiraUsuario;

    @Column(length = 50)
    private String parentescoAb;
    
    //Enums para exp 3
    
    public enum Responsable {
        USUARIO, RESPONSABLE_DEL_USUARIO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25) 
    private Responsable responsable = Responsable.USUARIO;

    public String getResponsableAsString() {
    	return this.responsable != null ? this.responsable.name() : "Valor por defecto";
    }

    public enum ServicioRetiro {
        PERSONA, HIJA, FAMILIAR;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25) 
    private ServicioRetiro servicioRetiro;

    public String getServicioRetiroAsString() {
        return this.servicioRetiro != null ? this.servicioRetiro.name() : "Valor por defecto";
    }

    
   //expediente 4 FORMATO PARA LA REFERENCIA DE PACIENTES
    
    @Column(length = 50)
    private String unidadSalud;
    
    @Column(length = 70)
    private String servicioRef;
    
    @Column(length = 10)
    private String expedienteRef;
    
    @Column(length = 50)
    private String nombreApellido;
    
    @Column(length = 3)
    private Integer edadReferencia;
    
    @Column(length = 14)
    private Integer sexoRef;
    
    @Column(length = 50)
    private String direccionRef;
    
    @Column(length = 50)
    private String comunidadRef;
    
    @Column(length = 50)
    private String municipioRef;
    
    @Column(length = 50)
    private String departamentoRef;
    
    @Column(length = 50)
    private String ocupacionReferencia;
    
    @Column(length = 50)
    private String comunicacionLlamar;
    
    @Column(length = 50)
    private String parentescoRef;
    
    @Column(length = 20)
    private String telefonoRef;
    
    @Column(length = 50)
    private String empleadorReferencia;
    
    @Column(length = 50)
    private String numeroSeguro;
    
    @Column(length = 50)
    private String motivoReferencia;
    
    @Column(length = 10)
    private String pulso;
    
    @Column(length = 10)
    private String presionArterial;
    
    @Column(length = 10)
    private String temperatura;
    
    @Column(length = 10)
    private String frecRespi;
    
    @Column(length = 10)
    private String peso;
    
    @Column(length = 10)
    private String talla;
    
    @Column(length = 100)  
    private String resumenClinico;
    
    @Column(length = 100)
    private String diagnosticoProblem;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Column(length = 33)
    private String horaEnvio;
    
    @Column(length = 50)
    private String acompRef;
    
    @Column(length = 50)
    private String envioServ;
    
    @Column(length = 50)
    private String contactoRef;
    
    @Column(length = 50)
    private String uniRef;
    
    @Column(length = 50)
    private String silaRef;
   
    @Column(length = 50)
    private String nomMedRef;  // Nombre del médico referente
    
    @Column(length = 50)
    private String serviRefbajo;
    @Column
    @Temporal(TemporalType.DATE)
    private Date fechaReci;
    @Column(length = 33)
    private String horaReci;

    //enum exp 4
    
 // Para el "Tipo de establecimiento":
    public enum TipoEstablecimiento {
        PUBLICO, PRIVADO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private TipoEstablecimiento tipoEstablecimiento;

    public String getTipoEstablecimientoAsString() {
        return this.tipoEstablecimiento != null ? this.tipoEstablecimiento.name() : "Valor por defecto";
    }

    // Para el "Tipo de referencia":
    public enum TipoReferencia {
        URGENTE, NO_URGENTE;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private TipoReferencia tipoReferencia;

    public String getTipoReferenciaAsString() {
        return this.tipoReferencia != null ? this.tipoReferencia.name() : "Valor por defecto";
    }

    // Para el "Asegurado activo":
    public enum AseguradoActivo {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AseguradoActivo aseguradoActivo;

    public String getAseguradoActivoAsString() {
        return this.aseguradoActivo != null ? this.aseguradoActivo.name() : "Valor por defecto";
    }

    // Para el "Accidente de trabajo":
    public enum AccidenteTrabajo {
        INTENCIONAL, AUTO_INFLIGIDO, ACCIDENTAL, SE_IGNORA;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AccidenteTrabajo accidenteTrabajo;

    public String getAccidenteTrabajoAsString() {
        return this.accidenteTrabajo != null ? this.accidenteTrabajo.name() : "Valor por defecto";
    }

    
    // Para el "Tipo Asegurado"
    public enum TipoAsegurado {
        COTIZANTE, BENEFICIARIO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25) 
    private TipoAsegurado tipoAsegurado;

    public String getTipoAseguradoAsString() {
        return this.tipoAsegurado != null ? this.tipoAsegurado.name() : "Valor por defecto";
    }


  //expediente 5 FORMATO PARA LA CONTRAREFERENCIA DE PACIENTES
    
    @Column(length = 50)
    private String contUniSalud;
    @Column(length = 50)
    private String servicioCont;
    @Column(length = 10)
    private String expedienteCont;
    @Column(length = 50)
    private String nomApCont;
    @Column(length = 3)
    private String edadCont;
    @Column(length = 10)
    private String sexoCont;
    @Column(length = 50)
    private String direccionCont;
    @Column(length = 50)
    private String municipioCont;
    @Column(length = 50)
    private String comunidadCont;
    @Column(length = 50)
    private String departCont;
    @Column(length = 50)
    private String ocupCont;
    @Column(length = 50)
    private String llamarCont;
    @Column(length = 50)
    private String parentescoCont;
    @Column(length = 20)
    private String telefCont;
    @Column(length = 50)
    private String emplCont;
    @Column(length = 20)
    private String numSegCont;
    @Column(length = 20)
    private String uniCont;
    @Temporal(TemporalType.DATE)
    private Date fechaEgreCont;
    @Column(length = 33)
    private String horaCont;
    @Column(length = 10)
    private String diasCont;
    @Column(length = 80)
    private String diagnostegre;
    @Column(length = 100)
    private String resumenCont;
    @Column(length = 100)
    private String recomCont;
    @Column(length = 100)
    private String paciCont;
    @Column(length = 100)
    private String unidadRefCont;
    @Column(length = 100)
    private String noPermitidaCont;
    @Column(length = 50)
    private String nomMedCont;
    
    //TIPO ESTA.
    public enum TipoEstablecimientoNuevo {
        PUBLICONT, PRIVADOCONT;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private TipoEstablecimientoNuevo tipoEstablecimientoNuevo;

    public String getTipoEstablecimientoNuevoAsString() {
        return this.tipoEstablecimientoNuevo != null ? this.tipoEstablecimientoNuevo.name() : "Valor por defecto";
    }
    
    //asegurado
    public enum AseguradoActivoNuevo {
        SICONT, NOCONT;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AseguradoActivoNuevo aseguradoActivoNuevo;

    public String getAseguradoActivoNuevoAsString() {
        return this.aseguradoActivoNuevo != null ? this.aseguradoActivoNuevo.name() : "Valor por defecto";
    }

    
    //acciden.
    public enum AccidenteTrabajoNuevo {
        INTENCIONALCONT, AUTO_INFLIGIDOCONT, ACCIDENTALCONT, SE_IGNORACONT;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AccidenteTrabajoNuevo accidenteTrabajoNuevo;

    public String getAccidenteTrabajoNuevoAsString() {
        return this.accidenteTrabajoNuevo != null ? this.accidenteTrabajoNuevo.name() : "Valor por defecto";
    }

    
    //refere
    public enum ReferenciaFue {
        ADECUADA, INADECUADA;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private ReferenciaFue referenciaFue;

    public String getReferenciaFueAsString() {
        return this.referenciaFue != null ? this.referenciaFue.name() : "Valor por defecto";
    }
    
    public enum tipoAseguradoHis {
        COTIZANTEHIS, BENEHIS;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private tipoAseguradoHis tipoAseguradoHis;

    public String getTipoAseguradoHisAsString() {
        return this.tipoAseguradoHis != null ? this.tipoAseguradoHis.name() : "Valor por defecto";
    }


  //expediente 6 NOTAS DE EVOLUCION Y TRATAMIENTO
    
    @Column(length = 100)
    private String nomEstbNot;
    @Column(length = 20)
    private Integer numExpeNot;
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
    private Integer numPagNot;
    @Column(length = 33)
    private String horaFechaNotUno;

  //expediente 7 NOTAS DE ENFERMERIA
    @Column(length = 33)
    private String horaFaltanteEnf;
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
    private Integer enfNumPagNot;
    @Column(length = 33)
    private String horaEnfNota;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDosNotasEnf;
    
    @Column(length = 20)
    private String obserCuidadoEnfDos;

    @Column(length = 20)
    private String planesdosEnf;
    
    @Column(length = 100)
    private String problemDos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEvoluDos;

    @Column(length = 33)
    private String horaEvoluDos;

    @Column(length = 2048)
    private String planesDos;
   

    //expediente 8 HISTORIA CLINICA
    
    @Column(length = 100)
    private String acostumbraMedicamento;
    
    @Column(length = 20)
    private String reposoAcciden;

    @Column(length = 20)
    private String tipoRh;
    
    @Column(length = 20)
    private String pesoUnMes;

    @Column(length = 20)
    private String pesoUnAnio;
    
    public enum SexoHis {
        MASCULINOHIS, FEMENINOHIS;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private SexoHis sexoHis;

    public String getSexoHisAsString() {
        return this.sexoHis != null ? this.sexoHis.name() : "Valor por defecto";
    }

    @Column(length = 40)
    private String fechaClic;
    
    @Column(length = 10)
    private Integer numExpHis;

    @Column(length = 50)
    private String nomClic;

    @Column(length = 20)
    private String carneClic;

    @Column(length = 50)
    private String nacClic;

    @Column(length = 50)
    private String direCic;

    @Column(length = 50)
    private String ocupaClic;

    @Column(length = 50)
    private String razaClic;

    @Column(length = 50)
    private String estadoClic;

    @Column(length = 20)
    private String numExpClic;

    @Column(length = 50)
    private String fechaNaClic;

    @Column(length = 50)
    private String residenClic;

    @Column(length = 60)
    private String ciudadClic;

    @Column(length = 57)
    private String escolaClic;

    @Column(length = 60)
    private String religiClic;

    @Column(length = 180)
    private String indiCausaClic;

    @Column(length = 3)
    private Integer numHijoClic;

    @Column(length = 180)
    private String enfermoFalleClic;

    @Column(length = 150)
    private String promeClic;

    @Column(length = 200)
    private String otroClic;

    @Column(length = 150)
    private String tipoClic;

    @Column(length = 150)
    private String tiempoSustClic;

    @Column(length = 150)
    private String contactClic;

    @Column(length = 150)
    private String tipoContaClic;

    @Column(length = 150)
    private String tiempoContaClic;

    @Column(length = 150)
    private String tipoRuidoClic;

    @Column(length = 150)
    private String tiempoRuidoClic;

    @Column(length = 150)
    private String viveCasaClic;

    @Column(length = 150)
    private String cuartoClic;

    @Column(length = 150)
    private Integer cantPersClic;

    @Column(length = 150)
    private String ensuCuartoClic;

    @Column(length = 150)
    private String cafe;

    @Column(length = 150)
    private String tabaco;

    @Column(length = 150)
    private String bebiAlco;

    @Column(length = 150)
    private String deport;

    @Column(length = 150)
    private String distracciones;

    @Column(length = 150)
    private String dieta;

    @Column(length = 150)
    private String otroCostum;

    @Column(length = 150)
    private String enfermeInf;

    @Column(length = 150)
    private String inmunizacion;

    @Column(length = 150)
    private String motivoConsul;

    @Column(length = 150)
    private String historiaActu;

    @Column(length = 200)
    private String cardiovas;

    @Column(length = 200)
    private String respirato;

    @Column(length = 200)
    private String digestiv;

    @Column(length = 200)
    private String urogeni;

    @Column(length = 200)
    private String endocri;

    @Column(length = 200)
    private String neuro;

    @Column(length = 200)
    private String organoSenti;

    @Column(length = 200)
    private String sintoGene;

    @Column(length = 200)
    private String gine;

    @Column(length = 200)
    private String psicoso;

    @Column(length = 150)
    private String pesoActu;

    @Column(length = 150)
    private String estatu;

    @Column(length = 150)
    private String pulsoUnoDecu;

    @Column(length = 150)
    private String pulsoDosDecu;

    @Column(length = 150)
    private String despuUnoEjer;

    @Column(length = 150)
    private String despuDosEjer;

    @Column(length = 150)
    private String tadecu;

    @Column(length = 150)
    private String sentado;

    @Column(length = 150)
    private String pie;

    @Column(length = 200)
    private String cabeza;

    @Column(length = 150)
    private String craneo;

    @Column(length = 200)
    private String ojos;

    @Column(length = 150)
    private String fdo;

    @Column(length = 200)
    private String nariz;

    @Column(length = 200)
    private String orofaringe;

    @Column(length = 200)
    private String oido;

    @Column(length = 150)
    private String cuello;

    @Column(length = 150)
    private String torax;

    @Column(length = 200)
    private String campleuro;

    @Column(length = 150)
    private String areaPre;

    @Column(length = 150)
    private String axiDer;

    @Column(length = 150)
    private String axiIzq;

    @Column(length = 150)
    private String mamaDer;

    @Column(length = 150)
    private String mamaIzq;

    @Column(length = 200)
    private String abdomen;

    @Column(length = 200)
    private String tr;

    @Column(length = 200)
    private String genita;

    @Column(length = 200)
    private String dorso;

    @Column(length = 200)
    private String miembroSup;

    @Column(length = 200)
    private String pulsoUltiHis;

    @Column(length = 200)
    private String miembroInf;

    @Column(length = 200)
    private String examenNeuro;
    
 // Enum para Hijos en Historia
    public enum hijosHisto {
        SIHI, NOHI;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private hijosHisto hijosHisto;

    public String getHijosHistoAsString() {
        return this.hijosHisto != null ? this.hijosHisto.name() : "Valor por defecto";
    }

    // Enum para Asma en Historia
    public enum AsmaHist {
        SIA, NOA;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AsmaHist asmaHist;

    public String getAsmaHistAsString() {
        return this.asmaHist != null ? this.asmaHist.name() : "Valor por defecto";
    }


    // Enum para Cáncer en Historia
    public enum CancerHis {
        SIC, NOC;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private CancerHis cancerHis;

    public String getCancerHisAsString() {
        return this.cancerHis != null ? this.cancerHis.name() : "Valor por defecto";
    }


    // Enum para Diabetes en Historia
    public enum Diabetes {
        SID, NOD;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Diabetes diabetes;

    public String getDiabetesAsString() {
        return this.diabetes != null ? this.diabetes.name() : "Valor por defecto";
    }


    // Enum para Epilepsia en Historia
    public enum Epilep {
        SIE, NOE;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Epilep epilep;

    public String getEpilepAsString() {
        return this.epilep != null ? this.epilep.name() : "Valor por defecto";
    }


    // Enum para Trastornos mentales en Historia
    public enum Transmenta {
        SIT, NOT;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Transmenta transmenta;

    public String getTransmentaAsString() {
        return this.transmenta != null ? this.transmenta.name() : "Valor por defecto";
    }

    // Enum para Obesidad en Historia
    public enum Obesidad {
        SIOB, NOOB;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Obesidad obesidad;

    public String getObesidadAsString() {
        return this.obesidad != null ? this.obesidad.name() : "Valor por defecto";
    }


    // Enum para Cardiopatías en Historia
    public enum Cardio {
        SICAR, NOCAR;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Cardio cardio;

    public String getCardioAsString() {
        return this.cardio != null ? this.cardio.name() : "Valor por defecto";
    }


    // Enum para Hipertensión en Historia
    public enum Hiperten {
        SIHIP, NOHIP;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Hiperten hiperten;

    public String getHipertenAsString() {
        return this.hiperten != null ? this.hiperten.name() : "Valor por defecto";
    }

    // Enum para Sífilis en Historia
    public enum Sifilis {
        SISI, NOSI;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Sifilis sifilis;

    public String getSifilisAsString() {
        return this.sifilis != null ? this.sifilis.name() : "Valor por defecto";
    }

    // Enum para Tuberculosis en Historia
    public enum Tuber {
        SITU, NOTU;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Tuber tuber;

    public String getTuberAsString() {
        return this.tuber != null ? this.tuber.name() : "Valor por defecto";
    }

    // Enum para Nefropatía en Historia
    public enum Nefro {
        SINE, NONE;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private Nefro nefro;

    public String getNefroAsString() {
        return this.nefro != null ? this.nefro.name() : "Valor por defecto";
    }

    // Enum para Otros en Historia
    public enum OtrosHis {
        SIOTR, NOOTR;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private OtrosHis otrosHis;

    public String getOtrosHisAsString() {
        return this.otrosHis != null ? this.otrosHis.name() : "Valor por defecto";
    }


    // Enum para Tipo de Paciente en Historia
    public enum TipoPacienteHis {
        ESTUDIANTE, COLABORADOR, CIVIL;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private TipoPacienteHis tipoPacienteHis;

    public String getTipoPacienteHisAsString() {
        return this.tipoPacienteHis != null ? this.tipoPacienteHis.name():"Valor por defecto";
    }

    @Column(length = 30)
    private String asmaParen;
    @Column(length = 30)
    private String cancerParen;
    @Column(length = 30)
    private String diabeteParen;
    @Column(length = 30)
    private String epilepParen;
    @Column(length = 30)
    private String transtorParen;
    @Column(length = 30)
    private String obesiParen;
    @Column(length = 30)
    private String cardioParen;
    @Column(length = 30)
    private String hiperParen;
    @Column(length = 30)
    private String sifiParen;
    @Column(length = 30)
    private String tuberParen;
    @Column(length = 30)
    private String nefroParen;
    @Column(length = 30)
    private String otroParen;
    @Column(length = 30)
    private String madreEdadHis;
    @Column(length = 30)
    private String madreSana;
    @Column(length = 30)
    private String madreEnfer;
    @Column(length = 30)
    private String madreCausa;
    @Column(length = 30)
    private String madreEdadMuer;
    @Column(length = 30)
    private String padreEdad;
    @Column(length = 30)
    private String padreSano;
    @Column(length = 30)
    private String padreEnfer;
    @Column(length = 30)
    private String padreCausa;
    @Column(length = 30)
    private String padreEdadMuer;
    @Column(length = 30)
    private String hermanoEdad;
    @Column(length = 30)
    private String hermaSnado;
    @Column(length = 30)
    private String hermaEnfer;
    @Column(length = 30)
    private String hermaCausa;
    @Column(length = 30)
    private String hermaEdadMuer;
    @Column(length = 30)
    private String esposEdad;
    @Column(length = 30)
    private String espoSano;
    @Column(length = 30)
    private String espoEnfe;
    @Column(length = 30)
    private String espoCausa;
    @Column(length = 30)
    private String espoEdad;
    
    
    public enum TipoJornadaHis {
        DIURNOHIS, NOCTURNOHIS, MIXTOHIS;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private TipoJornadaHis tipoJornadaHis;

    public String getTipoJornadaHisAsString() {
        return this.tipoJornadaHis != null ? this.tipoJornadaHis.name(): "Valor por defecto";
    }
    public enum SustanciasToxicasHis {
        SUSTOXICASHIS_SI, SUSTOXICASHIS_NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private SustanciasToxicasHis sustanciasToxicasHis;

    public String getSustanciasToxicasHisAsString() {
        return this.sustanciasToxicasHis != null ? this.sustanciasToxicasHis.name() : "Valor por defecto";
    }

    public enum RadiacionesHis {
        RADHIS_SI, RADHIS_NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private RadiacionesHis radiacionesHis;

    public String getRadiacionesHisAsString() {
        return this.radiacionesHis != null ? this.radiacionesHis.name() : "Valor por defecto";
    }

    public enum RuidoHis {
        RUIDOHIS_SI, RUIDOHIS_NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private RuidoHis ruidoHis;

    public String getRuidoHisAsString() {
        return this.ruidoHis != null ? this.ruidoHis.name(): "Valor por defecto";
    }
    
    public enum MedicamentosHis {
        MEDICAMENTOSHIS_SI, MEDICAMENTOSHIS_NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private MedicamentosHis medicamentosHis;

    public String getMedicamentosHisAsString() {
        return this.medicamentosHis != null ? this.medicamentosHis.name(): "Valor por defecto";
    }
    public enum ReposoHis {
        REPOSOHIS_SI, REPOSOHIS_NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private ReposoHis reposoHis;

    public String getReposoHisAsString() {
    	return this.reposoHis != null ? this.reposoHis.name():"Valor por defecto";
    }
    public enum PosicionLaboralHis {
        SENTADOHIS, PIEHIS, CAMINANDOHIS, MIXTOHIS, OFICINAHIS, TALLERHIS, AIRE_LIBREHIS;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private PosicionLaboralHis posicionLaboralHis;

    public String getPosicionLaboralHisAsString() {
        return this.posicionLaboralHis != null ? this.posicionLaboralHis.name() : "Valor por defecto";
    }

    //ant. patologico
    public enum AntAlerMed {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntAlerMed antAlerMed;

    public String getAntAlerMedAsString() {
        return this.antAlerMed != null ? this.antAlerMed.name() : "Valor por defecto";
    }

    public enum AntAlerCom {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntAlerCom antAlerCom;

    public String getAntAlerComAsString() {
        return this.antAlerCom != null ? this.antAlerCom.name() : "Valor por defecto";
    }

    public enum AntMala {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntMala antMala;

    public String getAntMalaAsString() {
        return this.antMala != null ? this.antMala.name() : "Valor por defecto";
    }

    public enum AntHepa {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntHepa antHepa;

    public String getAntHepaAsString() {
        return this.antHepa != null ? this.antHepa.name() : "Valor por defecto";
    }

    public enum AntHosp {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntHosp antHosp;

    public String getAntHospAsString() {
        return this.antHosp != null ? this.antHosp.name() : "Valor por defecto";
    }


    public enum AntOpe {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntOpe antOpe;

    public String getAntOpeAsString() {
        return this.antOpe != null ? this.antOpe.name() : "Valor por defecto";
    }


    public enum AntAsm {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntAsm antAsm;

    public String getAntAsmAsString() {
        return this.antAsm != null ? this.antAsm.name() : "Valor por defecto";
    }


    public enum AntPara {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntPara antPara;

    public String getAntParaAsString() {
        return this.antPara != null ? this.antPara.name() : "Valor por defecto";
    }


    public enum AntTuber {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntTuber antTuber;

    public String getAntTuberAsString() {
        return this.antTuber != null ? this.antTuber.name() : "Valor por defecto";
    }


    public enum AntSifi {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntSifi antSifi;

    public String getAntSifiAsString() {
        return this.antSifi != null ? this.antSifi.name() : "Valor por defecto";
    }


    public enum AntGono {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntGono antGono;

    public String getAntGonoAsString() {
        return this.antGono != null ? this.antGono.name() : "Valor por defecto";
    }


    public enum AntAmig {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntAmig antAmig;

    public String getAntAmigAsString() {
        return this.antAmig != null ? this.antAmig.name() : "Valor por defecto";
    }

    public enum AntTrans {
        SI, NO;
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 25)
    private AntTrans antTrans;

    public String getAntTransAsString() {
        return this.antTrans != null ? this.antTrans.name() : "Valor por defecto";
    }


    //expediente 9 CONSENTIMIENTO INFORMADO
    
    @Column(length = 150)
    private String nomLegal;

    @Column(length = 150)
    private String numCedCons;

    @Column(length = 150)
    private String direCasaCons;

    @Column(length = 150)
    private String nomFamCons;

    @Column(length = 150)
    private String numCedFamCons;

    @Column(length = 150)
    private String direCasaFamCons;

    @Column(length = 20)
    private String numCeluFamCons;

    
	//Expediente 10 HOJA IDENTIFICACION DE USUARIOS
    @Column(length = 20)
    private Integer numExpHoja;
    
	@Column(length = 100)
    private String establecimientoSalud;

    @Column(length = 100)
    private String nombreUsuario;

    @Column(length = 20)
    private String numeroCedula;

    @Column(length = 40)
    private String etnia;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(length = 10)
    private String edad;
    
    //Enums EXP.10 Inicio
    
    public enum Sexo {
        M, F
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Sexo sexo; // M or F
    
    public String getSexoAsString() {
        return this.sexo != null ? this.sexo.name() : "Valor por defecto";
    }


    public enum Categoria {
        COTIZANTE, CONYUGE, HIJO, JUBILADO
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private Categoria categoria;

    public String getCategoriaAsString() {
        return this.categoria != null ? this.categoria.name() : "Valor por defecto";
    }
    	
  //Enums EXP.10 Final

    @Column(length = 50)
    private String escolaridad;

    @Column(length = 50)
    private String ocupacion;

    @Column(length = 255)
    private String direccionResidencia;

    @Column(length = 50)
    private String localidad;

    @Column(length = 50)
    private String municipio;
    
    @Column(length = 50)
    private String telefonos;

    @Column(length = 50)
    private String departamento;

    @Column(length = 50)
    private String responsableEmergencia;

    @Column(length = 50)
    private String parentesco;

    @Column(length = 255)
    private String direccion;

    @Column(length = 50)
    private String empleador;
    
    @Column(length = 20)
    private String estadoCivil;

    @Column(length = 255)
    private String direccionEmpleador;

    @Column(length = 20)
    private String numeroAsegurado;

    @Column(length = 500)
    private String actualizacionDirecciones;

	
}
