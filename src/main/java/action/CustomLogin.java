package action;

import java.util.*;

import org.openxava.util.*;

import com.openxava.naviox.actions.*;
import com.openxava.naviox.impl.*;
import com.uam.CLINICA.model.*;

import service.*;

public class CustomLogin extends ForwardToOriginalURIBaseAction {

    public void execute() throws Exception {

        // Verifica si ya existen errores en el formulario
        if (getErrors().contains()) return;

        // Obtiene el nombre de usuario y la contrase�a ingresados en la vista
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");

        // Si el usuario o la contrase�a est�n vac�os, muestra un error
        if (Is.emptyString(userName, password)) {
            addError("Rellene todos los campos.");
            return;
        }

        // Llama al DAO para buscar al Recepcionista por c�dula
        IDAO dao = new ImplDAO();
        List<Recepcionista> lista = dao.get("Recepcionista.findByCedula", Recepcionista.class, userName);

        // Si no se encuentra al usuario o hay alg�n error, muestra un error
        if (lista == null || lista.isEmpty()) {
            addError("Usuario o contrase�a incorrectos.");
            return;
        }

        // Obtiene el primer (y �nico) Recepcionista de la lista
        Recepcionista recepcionista = lista.get(0);

        // Verifica si la contrase�a ingresada coincide con el hash almacenado
        if (!recepcionista.verifyPassword(password)) {
            addError("Contrase�a Incorrecta");
            return;
        }

        // Si la contrase�a es correcta, realiza el login
        SignInHelper.signIn(getRequest(), userName);
        
        // Limpia el formulario
        getView().reset();

        // Reinicia todos los m�dulos excepto el actual
        getContext().resetAllModulesExceptCurrent(getRequest());

        // Redirige a la URI original despu�s de un login exitoso
        forwardToOriginalURI();
    }
}

