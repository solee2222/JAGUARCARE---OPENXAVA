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
            parameters.put("numeroDeExpediente", expediente.getNumeroDeExpediente());
            parameters.put("numeroINSS", expediente.getNumeroINSS());
            parameters.put("diafechaNa", expediente.getDiafechaNa());
            parameters.put("mesfechaNa", expediente.getMesfechaNa());
            parameters.put("aniofechaNa", expediente.getAniofechaNa());
            parameters.put("silais", expediente.getSilais());
            parameters.put("municipioCarpeta", expediente.getMunicipioCarpeta());
            parameters.put("direccionDomiciliaria", expediente.getDireccionDomiciliaria());
            parameters.put("ultMovi", expediente.getUltMovi());
            parameters.put("dosM", expediente.getDosM());
            parameters.put("unoM", expediente.getUnoM());
            parameters.put("dosA", expediente.getDosA());
            parameters.put("unoA", expediente.getUnoA());
            parameters.put("diaUni", expediente.getDiaUni());
            parameters.put("mesUni", expediente.getMesUni());
            parameters.put("anioUni", expediente.getAnioUni());
            parameters.put("unidadCuadro", expediente.getUnidadCuadro());
            
            
            //expediente 2 LISTA DE PROBLEMAS
            parameters.put("fechaPro", expediente.getFechaPro());
            parameters.put("numero", expediente.getNumero());
            parameters.put("nombreProblema", expediente.getNombreProblema());
            
          //expediente 3 CONSTANCIA DE ABANDONO
            parameters.put("fechaIngreso", expediente.getFechaIngreso());
            parameters.put("fechaAb", expediente.getFechaAb());
            parameters.put("tiempoEstancia", expediente.getTiempoEstancia());
            parameters.put("expedienteAb", expediente.getExpedienteAb());
            parameters.put("nombresApellidosUsuario", expediente.getNombresApellidosUsuario());
            parameters.put("numeroCedAb", expediente.getNumeroCedAb());
            parameters.put("persona", expediente.getPersona());
            parameters.put("servicivoRef", expediente.getServicivoRef());
            parameters.put("ellos", expediente.getEllos());
            parameters.put("personaAbandono", expediente.getPersonaAbandono());
            parameters.put("nombrePersonaRetiraUsuario", expediente.getNombrePersonaRetiraUsuario());
            parameters.put("parentescoAb", expediente.getParentescoAb());
            
          //expediente 4 FORMATO PARA LA REFERENCIA DE PACIENTES
            parameters.put("unidadSalud", expediente.getUnidadSalud());
            parameters.put("servicioRef", expediente.getServicioRef());
            parameters.put("expedienteRef", expediente.getExpedienteRef());
            parameters.put("tiposEstablecimiento", expediente.getTiposEstablecimiento());
            parameters.put("nombreApellido", expediente.getNombreApellido());
            parameters.put("edadReferencia", expediente.getEdadReferencia());
            parameters.put("direccionRef", expediente.getDireccionRef());
            parameters.put("comunidadRef", expediente.getComunidadRef());
            parameters.put("municipioRef", expediente.getMunicipioRef());
            parameters.put("departamentoRef", expediente.getDepartamentoRef());
            parameters.put("ocupacionReferencia", expediente.getOcupacionReferencia());
            parameters.put("aseguradoActivo", expediente.getAseguradoActivo());
            parameters.put("accidenteTrabajo", expediente.getAccidenteTrabajo());
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
            parameters.put("nomMedRef", expediente.getNomMedRef());
            parameters.put("codMedico", expediente.getCodMedico());
            parameters.put("serviRefbajo", expediente.getServiRefbajo());
            
          //expediente 5 FORMATO PARA LA CONTRAREFERENCIA DE PACIENTES
            parameters.put("contUniSalud", expediente.getContUniSalud());
            parameters.put("servicioCont", expediente.getServicioCont());
            parameters.put("expedienteCont", expediente.getExpedienteCont());
            parameters.put("tipoEstablecimientoCont", expediente.getTipoEstablecimientoCont());
            parameters.put("nomApCont", expediente.getNomApCont());
            parameters.put("edadCont", expediente.getEdadCont());
            parameters.put("sexoCont", expediente.getSexoCont());
            parameters.put("direccionCont", expediente.getDireccionCont());
            parameters.put("municipioCont", expediente.getMunicipioCont());
            parameters.put("departCont", expediente.getDepartCont());
            parameters.put("ocupCont", expediente.getOcupCont());
            parameters.put("asegActCont", expediente.getAsegActCont());
            parameters.put("llamarCont", expediente.getLlamarCont());
            parameters.put("parentescoCont", expediente.getParentescoCont());
            parameters.put("telefCont", expediente.getTelefCont());
            parameters.put("emplCont", expediente.getEmplCont());
            parameters.put("numSegCont", expediente.getNumSegCont());
            parameters.put("fechaEgreCont", expediente.getFechaEgreCont());
            parameters.put("horaCont", expediente.getHoraCont());
            parameters.put("diasCont", expediente.getDiasCont());
            parameters.put("diagnostegre", expediente.getDiagnostegre());
            parameters.put("resumenCont", expediente.getResumenCont());
            parameters.put("recomCont", expediente.getRecomCont());
            parameters.put("paciCont", expediente.getPaciCont());
            parameters.put("unidadRefCont", expediente.getUnidadRefCont());
            parameters.put("tipoRefCont", expediente.getTipoRefCont());
            parameters.put("noPermitidaCont", expediente.getNoPermitidaCont());
            parameters.put("nomMedCont", expediente.getNomMedCont());
            //expediente 6 NOTAS DE EVOLUCION Y TRATAMIENTO
            
            parameters.put("nomEstbNot", expediente.getNomEstbNot());
            parameters.put("numExpeNot", expediente.getNumExpeNot());
            parameters.put("numCedNotas", expediente.getNumCedNotas());
            parameters.put("nomApNot", expediente.getNomApNot());
            parameters.put("fechHorNot", expediente.getFechHorNot());
            parameters.put("problNot", expediente.getProblNot());
            parameters.put("planes", expediente.getPlanes());
            parameters.put("numPagNot", expediente.getNumPagNot());

          //expediente 7 NOTAS DE ENFERMERIA
            parameters.put("enfNomEstbNot", expediente.getEnfNomEstbNot());
            parameters.put("enfNumExpeNot", expediente.getEnfNumExpeNot());
            parameters.put("enfNumCedNotas", expediente.getEnfNumCedNotas());
            parameters.put("enfNomApNot", expediente.getEnfNomApNot());
            parameters.put("enfFechHorNot", expediente.getEnfFechHorNot());
            parameters.put("enfObservNot", expediente.getEnfObservNot());
            parameters.put("enfPlanes", expediente.getEnfPlanes());
            parameters.put("enfNumPagNot", expediente.getEnfNumPagNot());
            
          //expediente 8 HISTORIA CLINICA - en proceso
            
            parameters.put("histClic", expediente.getHistClic());
            parameters.put("numExpClic", expediente.getNumExpClic());
            parameters.put("nomClic", expediente.getNomClic());
            parameters.put("nacimiClic", expediente.getNacimiClic());
            parameters.put("numCarnetClic", expediente.getNumCarnetClic());
            parameters.put("civilClic", expediente.getCivilClic());
            parameters.put("sexoClic", expediente.getSexoClic());
            parameters.put("tipoClic", expediente.getTipoClic());
            parameters.put("lugarNacClic", expediente.getLugarNacClic());
            parameters.put("residenClic", expediente.getResidenClic());
            parameters.put("colabClic", expediente.getColabClic());
            parameters.put("dirClic", expediente.getDirClic());
            parameters.put("ciudadClic", expediente.getCiudadClic());
            parameters.put("ocupaClic", expediente.getOcupaClic());
            parameters.put("escolaClic", expediente.getEscolaClic());
            parameters.put("razaClic", expediente.getRazaClic());
            parameters.put("religClic", expediente.getReligClic());
            parameters.put("sonClic", expediente.getSonClic());
            
            
            //expediente 10 HOJA DE IDENTIFICACION DE USUARIOS
            parameters.put("establecimientoSalud", expediente.getEstablecimientoSalud());
            parameters.put("nombreUsuario", expediente.getNombreUsuario());
            parameters.put("numeroCedula", expediente.getNumeroCedula());
            parameters.put("etnia", expediente.getEtnia());
            parameters.put("fecha", expediente.getFecha());
            parameters.put("fechaNacimiento", expediente.getFechaNacimiento());
            parameters.put("edad", expediente.getEdad());
            //parameters.put("sexoAsString", expediente.getSexoAsString());
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
            throw new RuntimeException("Failed to retrieve entity", e);
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
