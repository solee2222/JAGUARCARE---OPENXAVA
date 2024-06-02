package action;

import java.util.*;

import org.openxava.util.*;

import com.openxava.naviox.actions.*;
import com.openxava.naviox.impl.*;
import com.uam.CLINICA.model.*;

import service.*;

public class CustomLogin extends ForwardToOriginalURIBaseAction {
	
	public void execute() throws Exception {		

		if (getErrors().contains()) return; 
		String userName = getView().getValueString("user");
		String password = getView().getValueString("password");
		if (Is.emptyString(userName, password)) { 
			addError("Usuario No Autorizado"); 
			return;
		}		
		
		IDAO dao = new ImplDAO();
		List<Recepcionista> lista = new ArrayList<>();
		lista = dao.get("Recepcionista.findByPassword",Recepcionista.class,userName, password);
		if (lista == null || lista.isEmpty() || lista.size() == 0) {
			addError("Usuario No Autorizado"); 
			return;
		}
		SignInHelper.signIn(getRequest(), userName); 
		getView().reset();
		getContext().resetAllModulesExceptCurrent(getRequest()); 
		forwardToOriginalURI();
	}

}
