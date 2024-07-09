package com.uam.CLINICA.Calculadores;

import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.uam.CLINICA.model.*;

import service.*;

public class ValidadorCedRecepcionista implements IPropertyValidator {
    
    @Override
    public void validate(Messages messages, Object o, String s, String s1) throws Exception {
        IDAO dao = new ImplDAO();
        List<Recepcionista> listaCedula = dao.get("Recepcionista.findByCedula", Recepcionista.class, String.valueOf(o));
        if (listaCedula != null && listaCedula.size() > 0) {
            messages.add("La cédula del recepcionista ya existe");
        }
    }
}