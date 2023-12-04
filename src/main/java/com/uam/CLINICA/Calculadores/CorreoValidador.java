package com.uam.CLINICA.Calculadores;

import org.openxava.util.*;
import org.openxava.validators.*;

public class CorreoValidador implements IPropertyValidator {
	
    @Override
    public void validate(Messages messages, Object o, String s, String s1) throws Exception{
        String correo = (String) o;
        if (correo == null || !correo.contains("@")) {
            messages.add("El correo debe contener el símbolo '@'");
        }
    }

}
