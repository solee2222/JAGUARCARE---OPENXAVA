package com.uam.CLINICA.Calculadores;
import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.uam.CLINICA.model.*;

import service.*;

public class ValidadorNomRecepcionista implements IPropertyValidator {
    
    @Override
    public void validate(Messages messages, Object o, String s, String s1) throws Exception {
        IDAO dao = new ImplDAO();
        List<Recepcionista> listaNombre = dao.get("Recepcionista.findByName", Recepcionista.class, String.valueOf(o));
        if (listaNombre != null && listaNombre.size() > 0) {
            messages.add("El nombre del recepcionista ya existe.");
        }
    }
}