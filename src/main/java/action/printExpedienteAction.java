package action;
import java.util.*;

import org.openxava.actions.*;

import com.uam.CLINICA.model.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

public class printExpedienteAction extends JasperReportBaseAction {
    @Override
    public void execute() throws Exception {
        super.execute();
        addMessage("report_generated", "Expediente");
    }

    @Override
    protected Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();
        try {
            Expediente expediente = (Expediente) getView().getEntity(); 
            parameters.put("id", expediente.getId()); //id del expediente
            
            //expediente 1 CARPETA CLINICA MED
            parameters.put("primerApellido", expediente.getPrimerApellido());
            parameters.put("segundoApellido", expediente.getSegundoApellido());
            parameters.put("nombres", expediente.getNombres());
            parameters.put("unidadLinea", expediente.getUnidadLinea());
            parameters.put("numeroINSS", expediente.getNumeroINSS());
            parameters.put("diafechaNa", expediente.getDiafechaNa());
            parameters.put("mesfechaNa", expediente.getMesfechaNa());
            parameters.put("aniofechaNa", expediente.getAniofechaNa());
            parameters.put("silais", expediente.getSilais());
            parameters.put("municipioCarpeta", expediente.getMunicipioCarpeta());
            parameters.put("direccionDomiciliaria", expediente.getDireccionDomiciliaria());
            parameters.put("ultMovi", expediente.getUltMovi());
            parameters.put("dosMAsString", expediente.getDosMAsString()); // Enum para dosM
            parameters.put("unoMAsString", expediente.getUnoMAsString()); // Enum para unoM
            parameters.put("dosAAsString", expediente.getDosAAsString()); // Enum para dosA
            parameters.put("unoAAsString", expediente.getUnoAAsString()); // Enum para unoA
            parameters.put("diaUni", expediente.getDiaUni());
            parameters.put("mesUni", expediente.getMesUni());
            parameters.put("anioUni", expediente.getAnioUni());
            parameters.put("unidadCuadro", expediente.getUnidadCuadro());
            
            
            //expediente 2 LISTA DE PROBLEMAS
            parameters.put("fechaPro", expediente.getFechaPro());
            parameters.put("numero", expediente.getNumero());
            parameters.put("nombreProblema", expediente.getNombreProblema());
            parameters.put("estadoProblemaAsString", expediente.getEstadoProblemaAsString()); // Enum
            parameters.put("estadoProblemaDosAsString", expediente.getEstadoProblemaDosAsString()); // Enum
            parameters.put("estadoProblemaTresAsString", expediente.getEstadoProblemaTresAsString()); // Enum
            parameters.put("estadoProblemaCuatroAsString", expediente.getEstadoProblemaCuatroAsString()); // Enum
            parameters.put("estadoProblemaCincoAsString", expediente.getEstadoProblemaCincoAsString()); // Enum
            parameters.put("estadoProblemaSeisAsString", expediente.getEstadoProblemaSeisAsString()); // Enum
            parameters.put("estadoProblemaSieteAsString", expediente.getEstadoProblemaSieteAsString()); // Enum
            parameters.put("estadoProblemaOchoAsString", expediente.getEstadoProblemaOchoAsString()); // Enum
            parameters.put("estadoProblemaNueveAsString", expediente.getEstadoProblemaNueveAsString()); // Enum
            parameters.put("nombreProblema", expediente.getNombreProblema());
            parameters.put("nombreProblemaDos", expediente.getNombreProblemaDos());
            parameters.put("nombreProblemaTres", expediente.getNombreProblemaTres());
            parameters.put("nombreProblemaCuatro", expediente.getNombreProblemaCuatro());
            parameters.put("nombreProblemaCinco", expediente.getNombreProblemaCinco());
            parameters.put("nombreProblemaSeis", expediente.getNombreProblemaSeis());
            parameters.put("nombreProblemaSiete", expediente.getNombreProblemaSiete());
            parameters.put("nombreProblemaOcho", expediente.getNombreProblemaOcho());
            parameters.put("nombreProblemaNueve", expediente.getNombreProblemaNueve());

           
          //expediente 3 CONSTANCIA DE ABANDONO
            parameters.put("expnumero", expediente.getExpnumero());
            parameters.put("fechaIngreso", expediente.getFechaIngreso());
            parameters.put("fechaAb", expediente.getFechaAb());
            parameters.put("horaAb", expediente.getHoraAb());
            parameters.put("responsableAsString", expediente.getResponsableAsString());
            parameters.put("servicioRetiroAsString", expediente.getServicioRetiroAsString());
            parameters.put("horaIngre", expediente.getHoraIngre());
            parameters.put("tiempoEstancia", expediente.getTiempoEstancia());
            parameters.put("nombresApellidosUsuario", expediente.getNombresApellidosUsuario());
            parameters.put("numeroCedAb", expediente.getNumeroCedAb());
            parameters.put("nombreFirmante", expediente.getNombreFirmante());
            parameters.put("servicioSaludRetiro", expediente.getServicioSaludRetiro());
            parameters.put("diagnosticoRazonAbandono", expediente.getDiagnosticoRazonAbandono());
            parameters.put("razones", expediente.getRazones());
            parameters.put("responsableUsuario", expediente.getResponsableUsuario());
            parameters.put("nombrePersonaRetiraUsuario", expediente.getNombrePersonaRetiraUsuario());
            parameters.put("parentescoAb", expediente.getParentescoAb());
            
          //expediente 4 FORMATO PARA LA REFERENCIA DE PACIENTES
            parameters.put("unidadSalud", expediente.getUnidadSalud());
            parameters.put("servicioRef", expediente.getServicioRef());
            parameters.put("expedienteRef", expediente.getExpedienteRef());
            parameters.put("nombreApellido", expediente.getNombreApellido());
            parameters.put("edadReferencia", expediente.getEdadReferencia());
            parameters.put("sexoRef", expediente.getSexoRef());
            parameters.put("direccionRef", expediente.getDireccionRef());
            parameters.put("comunidadRef", expediente.getComunidadRef());
            parameters.put("municipioRef", expediente.getMunicipioRef());
            parameters.put("departamentoRef", expediente.getDepartamentoRef());
            parameters.put("ocupacionReferencia", expediente.getOcupacionReferencia());
            parameters.put("comunicacionLlamar", expediente.getComunicacionLlamar());
            parameters.put("parentescoRef", expediente.getParentescoRef());
            parameters.put("telefonoRef", expediente.getTelefonoRef());
            parameters.put("empleadorReferencia", expediente.getEmpleadorReferencia());
            parameters.put("numeroSeguro", expediente.getNumeroSeguro());
            parameters.put("motivoReferencia", expediente.getMotivoReferencia());
            parameters.put("pulso", expediente.getPulso());
            parameters.put("presionArterial", expediente.getPresionArterial());
            parameters.put("temperatura", expediente.getTemperatura());
            parameters.put("frecRespi", expediente.getFrecRespi());
            parameters.put("peso", expediente.getPeso());
            parameters.put("talla", expediente.getTalla());
            parameters.put("resumenClinico", expediente.getResumenClinico());
            parameters.put("diagnosticoProblem", expediente.getDiagnosticoProblem());
            parameters.put("fechaEnvio", expediente.getFechaEnvio());
            parameters.put("horaEnvio", expediente.getHoraEnvio());
            parameters.put("acompRef", expediente.getAcompRef());
            parameters.put("envioServ", expediente.getEnvioServ());
            parameters.put("contactoRef", expediente.getContactoRef());
            parameters.put("uniRef", expediente.getUniRef());
            parameters.put("silaRef", expediente.getSilaRef());
            parameters.put("nomMedRef", expediente.getNomMedRef());
            parameters.put("serviRefbajo", expediente.getServiRefbajo());
            parameters.put("fechaReci", expediente.getFechaReci());
            parameters.put("horaReci", expediente.getHoraReci());
            parameters.put("tipoEstablecimientoAsString", expediente.getTipoEstablecimientoAsString());
            parameters.put("tipoReferenciaAsString", expediente.getTipoReferenciaAsString());
            parameters.put("aseguradoActivoAsString", expediente.getAseguradoActivoAsString());
            parameters.put("accidenteTrabajoAsString", expediente.getAccidenteTrabajoAsString());
            parameters.put("tipoAseguradoAsString", expediente.getTipoAseguradoAsString());


          //expediente 5 FORMATO PARA LA CONTRAREFERENCIA DE PACIENTES
            parameters.put("contUniSalud", expediente.getContUniSalud());
            parameters.put("servicioCont", expediente.getServicioCont());
            parameters.put("expedienteCont", expediente.getExpedienteCont());
            parameters.put("nomApCont", expediente.getNomApCont());
            parameters.put("edadCont", expediente.getEdadCont());
            parameters.put("sexoCont", expediente.getSexoCont());
            parameters.put("direccionCont", expediente.getDireccionCont());
            parameters.put("municipioCont", expediente.getMunicipioCont());
            parameters.put("departCont", expediente.getDepartCont());
            parameters.put("ocupCont", expediente.getOcupCont());
            parameters.put("llamarCont", expediente.getLlamarCont());
            parameters.put("parentescoCont", expediente.getParentescoCont());
            parameters.put("telefCont", expediente.getTelefCont());
            parameters.put("emplCont", expediente.getEmplCont());
            parameters.put("uniCont", expediente.getEmplCont());
            parameters.put("numSegCont", expediente.getNumSegCont());
            parameters.put("fechaEgreCont", expediente.getFechaEgreCont());
            parameters.put("horaCont", expediente.getHoraCont());
            parameters.put("diasCont", expediente.getDiasCont());
            parameters.put("diagnostegre", expediente.getDiagnostegre());
            parameters.put("resumenCont", expediente.getResumenCont());
            parameters.put("recomCont", expediente.getRecomCont());
            parameters.put("paciCont", expediente.getPaciCont());
            parameters.put("unidadRefCont", expediente.getUnidadRefCont());
            parameters.put("noPermitidaCont", expediente.getNoPermitidaCont());
            parameters.put("nomMedCont", expediente.getNomMedCont());
            parameters.put("tipoEstablecimientoNuevoAsString", expediente.getTipoEstablecimientoNuevoAsString());
            parameters.put("aseguradoActivoNuevoAsString", expediente.getAseguradoActivoNuevoAsString());
            parameters.put("accidenteTrabajoNuevoAsString", expediente.getAccidenteTrabajoNuevoAsString());
            parameters.put("referenciaFueAsString", expediente.getReferenciaFueAsString());
            parameters.put("tipoAseguradoHisAsString", expediente.getTipoAseguradoHisAsString()); // Enum


            //expediente 6 NOTAS DE EVOLUCION Y TRATAMIENTO
            parameters.put("horaFechaNotUno", expediente.getHoraFechaNotUno());
            parameters.put("nomEstbNot", expediente.getNomEstbNot());
            parameters.put("numExpeNot", expediente.getNumExpeNot());
            parameters.put("numCedNotas", expediente.getNumCedNotas());
            parameters.put("nomApNot", expediente.getNomApNot());
            parameters.put("fechHorNot", expediente.getFechHorNot());
            parameters.put("problNot", expediente.getProblNot());
            parameters.put("planes", expediente.getPlanes());
            parameters.put("numPagNot", expediente.getNumPagNot());
            parameters.put("problemDos", expediente.getProblemDos()); // Problema en la segunda nota
            parameters.put("fechaEvoluDos", expediente.getFechaEvoluDos()); // Fecha de la evolución en la segunda nota
            parameters.put("horaEvoluDos", expediente.getHoraEvoluDos()); // Hora de la evolución en la segunda nota
            parameters.put("planesDos", expediente.getPlanesDos()); // Planes para la segunda nota

          //expediente 7 NOTAS DE ENFERMERIA
            parameters.put("enfNomEstbNot", expediente.getEnfNomEstbNot());
            parameters.put("enfNumExpeNot", expediente.getEnfNumExpeNot());
            parameters.put("enfNumCedNotas", expediente.getEnfNumCedNotas());
            parameters.put("enfNomApNot", expediente.getEnfNomApNot());
            parameters.put("enfFechHorNot", expediente.getEnfFechHorNot());
            parameters.put("enfObservNot", expediente.getEnfObservNot());
            parameters.put("enfPlanes", expediente.getEnfPlanes());
            parameters.put("enfNumPagNot", expediente.getEnfNumPagNot());
            parameters.put("horaEnfNota", expediente.getHoraEnfNota()); // Hora de la nota de enfermería
            parameters.put("fechaDosNotasEnf", expediente.getFechaDosNotasEnf()); // Fecha de la segunda nota de enfermería
            parameters.put("obserCuidadoEnfDos", expediente.getObserCuidadoEnfDos()); // Observaciones de cuidado en la segunda nota de enfermería
            parameters.put("planesdosEnf", expediente.getPlanesdosEnf()); // Planes en la segunda nota de enfermería
            parameters.put("horaFaltanteEnf", expediente.getHoraFaltanteEnf());
            
          //expediente 8 HISTORIA CLINICA
            parameters.put("reposoAcciden", expediente.getReposoAcciden()); // Reposo por accidente
            parameters.put("tipoRh", expediente.getTipoRh()); // Tipo de Rh
            parameters.put("pesoUnMes", expediente.getPesoUnMes()); // Peso al mes
            parameters.put("pesoUnAnio", expediente.getPesoUnAnio()); // Peso al año
            parameters.put("sexoHisAsString", expediente.getSexoHisAsString()); //Enum
            parameters.put("tipoJornadaHisAsString", expediente.getTipoJornadaHisAsString()); // Enum
            parameters.put("sustanciasToxicasHisAsString", expediente.getSustanciasToxicasHisAsString()); // Enum
            parameters.put("radiacionesHisAsString", expediente.getRadiacionesHisAsString()); // Enum
            parameters.put("ruidoHisAsString", expediente.getRuidoHisAsString()); // Enum
            parameters.put("medicamentosHisAsString", expediente.getMedicamentosHisAsString()); // Enum
            parameters.put("reposoHisAsString", expediente.getReposoHisAsString()); // Enum
            parameters.put("posicionLaboralHisAsString", expediente.getPosicionLaboralHisAsString()); // Enum
            parameters.put("fechaClic", expediente.getFechaClic());
            parameters.put("numExpHis", expediente.getNumExpHis());
            parameters.put("nomClic", expediente.getNomClic());
            parameters.put("carneClic", expediente.getCarneClic());
            parameters.put("nacClic", expediente.getNacClic());
            parameters.put("direCic", expediente.getDireCic());
            parameters.put("ocupaClic", expediente.getOcupaClic());
            parameters.put("razaClic", expediente.getRazaClic());
            parameters.put("estadoClic", expediente.getEstadoClic());
            parameters.put("numExpClic", expediente.getNumExpClic());
            parameters.put("fechaNaClic", expediente.getFechaNaClic());
            parameters.put("residenClic", expediente.getResidenClic());
            parameters.put("ciudadClic", expediente.getCiudadClic());
            parameters.put("escolaClic", expediente.getEscolaClic());
            parameters.put("religiClic", expediente.getReligiClic());
            parameters.put("indiCausaClic", expediente.getIndiCausaClic());
            parameters.put("numHijoClic", expediente.getNumHijoClic());
            parameters.put("enfermoFalleClic", expediente.getEnfermoFalleClic());
            parameters.put("promeClic", expediente.getPromeClic());
            parameters.put("otroClic", expediente.getOtroClic());
            parameters.put("tipoClic", expediente.getTipoClic());
            parameters.put("tiempoSustClic", expediente.getTiempoSustClic());
            parameters.put("contactClic", expediente.getContactClic());
            parameters.put("tipoContaClic", expediente.getTipoContaClic());
            parameters.put("tiempoContaClic", expediente.getTiempoContaClic());            
            parameters.put("tipoRuidoClic", expediente.getTipoRuidoClic());
            parameters.put("tiempoRuidoClic", expediente.getTiempoRuidoClic());
            parameters.put("viveCasaClic", expediente.getViveCasaClic());
            parameters.put("cuartoClic", expediente.getCuartoClic());
            parameters.put("cantPersClic", expediente.getCantPersClic());
            parameters.put("ensuCuartoClic", expediente.getEnsuCuartoClic());
            parameters.put("cafe", expediente.getCafe());
            parameters.put("tabaco", expediente.getTabaco());
            parameters.put("bebiAlco", expediente.getBebiAlco());
            parameters.put("deport", expediente.getDeport());
            parameters.put("distracciones", expediente.getDistracciones());
            parameters.put("dieta", expediente.getDieta());
            parameters.put("otroCostum", expediente.getOtroCostum());
            parameters.put("enfermeInf", expediente.getEnfermeInf());
            parameters.put("inmunizacion", expediente.getInmunizacion());
            parameters.put("motivoConsul", expediente.getMotivoConsul());
            parameters.put("historiaActu", expediente.getHistoriaActu());
            parameters.put("cardiovas", expediente.getCardiovas());
            parameters.put("respirato", expediente.getRespirato());
            parameters.put("digestiv", expediente.getDigestiv());
            parameters.put("urogeni", expediente.getUrogeni());
            parameters.put("endocri", expediente.getEndocri());
            parameters.put("neuro", expediente.getNeuro());
            parameters.put("organoSenti", expediente.getOrganoSenti());
            parameters.put("sintoGene", expediente.getSintoGene());
            parameters.put("gine", expediente.getGine());
            parameters.put("psicoso", expediente.getPsicoso());
            parameters.put("pesoActu", expediente.getPesoActu());
            parameters.put("estatu", expediente.getEstatu());            
            parameters.put("pulsoUnoDecu", expediente.getPulsoUnoDecu());
            parameters.put("pulsoDosDecu", expediente.getPulsoDosDecu());
            parameters.put("despuUnoEjer", expediente.getDespuUnoEjer());
            parameters.put("despuDosEjer", expediente.getDespuDosEjer());
            parameters.put("tadecu", expediente.getTadecu());
            parameters.put("sentado", expediente.getSentado());
            parameters.put("pie", expediente.getPie());
            parameters.put("cabeza", expediente.getCabeza());
            parameters.put("craneo", expediente.getCraneo());
            parameters.put("ojos", expediente.getOjos());
            parameters.put("fdo", expediente.getFdo());
            parameters.put("nariz", expediente.getNariz());
            parameters.put("orofaringe", expediente.getOrofaringe());
            parameters.put("oido", expediente.getOido());
            parameters.put("cuello", expediente.getCuello());
            parameters.put("torax", expediente.getTorax());
            parameters.put("campleuro", expediente.getCampleuro());
            parameters.put("areaPre", expediente.getAreaPre());
            parameters.put("axiDer", expediente.getAxiDer());
            parameters.put("axiIzq", expediente.getAxiIzq());
            parameters.put("mamaDer", expediente.getMamaDer());
            parameters.put("mamaIzq", expediente.getMamaIzq());
            parameters.put("abdomen", expediente.getAbdomen());
            parameters.put("tr", expediente.getTr());
            parameters.put("genita", expediente.getGenita());
            parameters.put("dorso", expediente.getDorso());
            parameters.put("miembroSup", expediente.getMiembroSup());
            parameters.put("pulsoUltiHis", expediente.getPulsoUltiHis());
            parameters.put("miembroInf", expediente.getMiembroInf());
            parameters.put("examenNeuro", expediente.getExamenNeuro());
            parameters.put("asmaParen", expediente.getAsmaParen());
            parameters.put("cancerParen", expediente.getCancerParen());
            parameters.put("diabeteParen", expediente.getDiabeteParen());
            parameters.put("epilepParen", expediente.getEpilepParen());
            parameters.put("transtorParen", expediente.getTranstorParen());
            parameters.put("obesiParen", expediente.getObesiParen());
            parameters.put("cardioParen", expediente.getCardioParen());
            parameters.put("hiperParen", expediente.getHiperParen());
            parameters.put("sifiParen", expediente.getSifiParen());
            parameters.put("tuberParen", expediente.getTuberParen());
            parameters.put("nefroParen", expediente.getNefroParen());
            parameters.put("otroParen", expediente.getOtroParen());
            parameters.put("madreEdadHis", expediente.getMadreEdadHis());
            parameters.put("madreSana", expediente.getMadreSana());
            parameters.put("madreEnfer", expediente.getMadreEnfer());
            parameters.put("madreCausa", expediente.getMadreCausa());
            parameters.put("madreEdadMuer", expediente.getMadreEdadMuer());
            parameters.put("padreEdad", expediente.getPadreEdad());
            parameters.put("padreSano", expediente.getPadreSano());
            parameters.put("padreEnfer", expediente.getPadreEnfer());
            parameters.put("padreCausa", expediente.getPadreCausa());
            parameters.put("padreEdadMuer", expediente.getPadreEdadMuer());
            parameters.put("hermanoEdad", expediente.getHermanoEdad());
            parameters.put("hermaSnado", expediente.getHermaSnado());
            parameters.put("hermaEnfer", expediente.getHermaEnfer());
            parameters.put("hermaCausa", expediente.getHermaCausa());
            parameters.put("hermaEdadMuer", expediente.getHermaEdadMuer());
            parameters.put("esposEdad", expediente.getEsposEdad());
            parameters.put("espoSano", expediente.getEspoSano());
            parameters.put("espoEnfe", expediente.getEspoEnfe());
            parameters.put("espoCausa", expediente.getEspoCausa());
            parameters.put("espoEdad", expediente.getEspoEdad());
            parameters.put("hijosHistoAsString", expediente.getHijosHistoAsString()); //Enum
            parameters.put("asmaHistAsString", expediente.getAsmaHistAsString()); //Enum
            parameters.put("cancerHisAsString", expediente.getCancerHisAsString()); //Enum
            parameters.put("diabetesAsString", expediente.getDiabetesAsString()); //Enum
            parameters.put("epilepAsString", expediente.getEpilepAsString()); //Enum
            parameters.put("transmentaAsString", expediente.getTransmentaAsString()); //Enum
            parameters.put("obesidadAsString", expediente.getObesidadAsString()); //Enum
            parameters.put("cardioAsString", expediente.getCardioAsString()); //Enum
            parameters.put("hipertenAsString", expediente.getHipertenAsString()); //Enum
            parameters.put("sifilisAsString", expediente.getSifilisAsString()); //Enum
            parameters.put("tuberAsString", expediente.getTuberAsString()); //Enum
            parameters.put("nefroAsString", expediente.getNefroAsString()); //Enum
            parameters.put("otrosHisAsString", expediente.getOtrosHisAsString()); //Enum
            parameters.put("tipoPacienteHisAsString", expediente.getTipoPacienteHisAsString()); //Enum
            parameters.put("antAlerMedAsString", expediente.getAntAlerMedAsString()); // Enum
            parameters.put("antAlerComAsString", expediente.getAntAlerComAsString()); // Enum
            parameters.put("antMalaAsString", expediente.getAntMalaAsString()); // Enum
            parameters.put("antHepaAsString", expediente.getAntHepaAsString()); // Enum
            parameters.put("antHospAsString", expediente.getAntHospAsString()); // Enum
            parameters.put("antOpeAsString", expediente.getAntOpeAsString()); // Enum
            parameters.put("antAsmAsString", expediente.getAntAsmAsString()); // Enum
            parameters.put("antParaAsString", expediente.getAntParaAsString()); // Enum
            parameters.put("antTuberAsString", expediente.getAntTuberAsString()); // Enum
            parameters.put("antSifiAsString", expediente.getAntSifiAsString()); // Enum
            parameters.put("antGonoAsString", expediente.getAntGonoAsString()); // Enum
            parameters.put("antAmigAsString", expediente.getAntAmigAsString()); // Enum
            parameters.put("antTransAsString", expediente.getAntTransAsString()); // Enum
            parameters.put("acostumbraMedicamento", expediente.getAcostumbraMedicamento());

          //expediente 9 CONSENTIMIENTO INFORMADO
            parameters.put("nomLegal", expediente.getNomLegal());
            parameters.put("numCedCons", expediente.getNumCedCons());
            parameters.put("direCasaCons", expediente.getDireCasaCons());
            parameters.put("nomFamCons", expediente.getNomFamCons());
            parameters.put("numCedFamCons", expediente.getNumCedFamCons());
            parameters.put("direCasaFamCons", expediente.getDireCasaFamCons());
            parameters.put("numCeluFamCons", expediente.getNumCeluFamCons());

            //expediente 10 HOJA DE IDENTIFICACION DE USUARIOS
            parameters.put("numExpHoja", expediente.getNumExpHoja());
            parameters.put("establecimientoSalud", expediente.getEstablecimientoSalud());
            parameters.put("nombreUsuario", expediente.getNombreUsuario());
            parameters.put("numeroCedula", expediente.getNumeroCedula());
            parameters.put("etnia", expediente.getEtnia());
            parameters.put("fecha", expediente.getFecha());
            parameters.put("fechaNacimiento", expediente.getFechaNacimiento());
            parameters.put("edad", expediente.getEdad());
            parameters.put("sexoAsString", expediente.getSexoAsString()); //Enum
            parameters.put("categoriaAsString", expediente.getCategoriaAsString()); //Enum
            parameters.put("escolaridad", expediente.getEscolaridad());
            parameters.put("ocupacion", expediente.getOcupacion());
            parameters.put("direccionResidencia", expediente.getDireccionResidencia());
            parameters.put("localidad", expediente.getLocalidad());
            parameters.put("municipio", expediente.getMunicipio());
            parameters.put("departamento", expediente.getDepartamento());
            parameters.put("responsableEmergencia", expediente.getResponsableEmergencia());
            parameters.put("parentesco", expediente.getParentesco());
            parameters.put("telefonos", expediente.getTelefonos());
            parameters.put("estadoCivil", expediente.getEstadoCivil());
            parameters.put("direccion", expediente.getDireccion());
            parameters.put("empleador", expediente.getEmpleador());
            parameters.put("direccionEmpleador", expediente.getDireccionEmpleador());
            parameters.put("numeroAsegurado", expediente.getNumeroAsegurado());
            parameters.put("actualizacionDirecciones", expediente.getActualizacionDirecciones());
            
        } catch (Exception e) {
            throw new RuntimeException("Error al producir el reporte", e);
        }
        return parameters;
    }

    @Override
    protected JRDataSource getDataSource() throws Exception {
        List<Expediente> expedientes = Collections.singletonList((Expediente) getView().getEntity());
        return new JRBeanCollectionDataSource(expedientes);
    }

    @Override
    protected String getJRXML() {
        return "Hoja_Identificacion_Usuarios.jrxml"; 
    }
}
