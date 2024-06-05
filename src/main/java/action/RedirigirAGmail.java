package action;

import org.openxava.actions.*;

public class RedirigirAGmail extends BaseAction implements IForwardAction {

    public void execute() throws Exception {
    }

    public String getForwardURI() {
    return "https://mail.google.com/mail/";
    }

    public boolean inNewWindow() {
    return true;
    }
}
