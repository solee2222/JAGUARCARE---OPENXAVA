package com.uam.CLINICA.Calculadores;

import java.util.*;

import org.openxava.util.*;
import org.openxava.validators.*;

import com.uam.CLINICA.model.*;

import service.*;

public class ValidadorSintoma  implements IPropertyValidator{
	
	 @Override
	    public void validate(Messages messages, Object o,String s, String s1) throws Exception {
	        IDAO dao = new ImplDAO();
	        List<Sintomatologia> lista = dao.get("Sintomatologia.findByNombre", Sintomatologia.class, String.valueOf(o));
	        if (lista != null && lista.size() > 0) {
	            messages.add("El nombre del sintoma ya existe");
	        }
	    }

}
