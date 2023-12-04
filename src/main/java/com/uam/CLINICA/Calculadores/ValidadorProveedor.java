package com.uam.CLINICA.Calculadores;

import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.uam.CLINICA.model.*;

import service.*;


public class ValidadorProveedor  implements IPropertyValidator{
	
	@Override
    public void validate(Messages messages, Object o, String s, String s1) throws Exception {
        IDAO dao = new ImplDAO();
        List<Proveedor> lista = dao.get("Proveedor.findByNombre", Proveedor.class, String.valueOf(o));
        if (lista != null && lista.size() > 0) {
            messages.add("El proveedor ya existe");
        }
    }
	
}
