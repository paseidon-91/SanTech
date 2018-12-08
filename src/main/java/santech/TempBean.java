package santech;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Alexandr
 */
@Named
@SessionScoped
public class TempBean implements Serializable {

	private static final long serialVersionUID = 817227825896715695L;

	private String testMessage = "Test MESSAGE";

	public String getTestMessage() {
		return testMessage;
	}

	public void setTestMessage(String testMessage) {
		this.testMessage = testMessage;
	}
}
