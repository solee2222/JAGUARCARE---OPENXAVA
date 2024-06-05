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
            Expediente expediente = (Expediente) getView().getEntity(); // This can throw an Exception
            parameters.put("id", expediente.getId());
            parameters.put("establecimientoSalud", expediente.getEstablecimientoSalud());
            parameters.put("nombreUsuario", expediente.getNombreUsuario());
            parameters.put("numeroCedula", expediente.getNumeroCedula());
            parameters.put("etnia", expediente.getEtnia());
            parameters.put("fecha", expediente.getFecha());
            parameters.put("fechaNacimiento", expediente.getFechaNacimiento());
            parameters.put("edad", expediente.getEdad());
            parameters.put("sexo", expediente.getSexo()); // Assuming 'sexo' is stored as char
            parameters.put("categoria", expediente.getCategoria());
            parameters.put("escolaridad", expediente.getEscolaridad());
            parameters.put("ocupacion", expediente.getOcupacion());
            parameters.put("direccionResidencia", expediente.getDireccionResidencia());
            parameters.put("localidad", expediente.getLocalidad());
            parameters.put("municipio", expediente.getMunicipio());
            parameters.put("departamento", expediente.getDepartamento());
            parameters.put("responsableEmergencia", expediente.getResponsableEmergencia());
            parameters.put("parentesco", expediente.getParentesco());
            parameters.put("direccion", expediente.getDireccion());
            parameters.put("empleador", expediente.getEmpleador());
            parameters.put("direccionEmpleador", expediente.getDireccionEmpleador());
            parameters.put("numeroAsegurado", expediente.getNumeroAsegurado());
            parameters.put("actualizacionDirecciones", expediente.getActualizacionDirecciones());
            parameters.put("nombreFirmaPersonalAdmision", expediente.getNombreFirmaPersonalAdmision());
            
        } catch (Exception e) {
            // Handle the exception or rethrow as a runtime exception
            throw new RuntimeException("Failed to retrieve entity", e);
        }
        return parameters;
    }

    @Override
    protected JRDataSource getDataSource() throws Exception {
        List<Expediente> expedientes = Collections.singletonList((Expediente) getView().getEntity()); // Handle or declare this exception
        return new JRBeanCollectionDataSource(expedientes);
    }

    @Override
    protected String getJRXML() {
        return "Hoja_Identificacion_Usuarios.jrxml"; // Ensure this file is on the classpath
    }
}
