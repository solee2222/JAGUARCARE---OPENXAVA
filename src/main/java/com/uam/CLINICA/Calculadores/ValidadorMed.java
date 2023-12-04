package com.uam.CLINICA.Calculadores;

import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.uam.CLINICA.model.*;

import service.*;

public class ValidadorMed implements IPropertyValidator{
	
	  @Override
	    public void validate(Messages messages, Object o, String s, String s1) throws Exception {
	        IDAO dao = new ImplDAO();
	        List<Medicamento> lista = dao.get("Medicamento.findByNombre", Medicamento.class, String.valueOf(o));
	        if (lista != null && lista.size() > 0) {
	            messages.add("El nombre del medicamento ya existe");
	        }
	    }

}
