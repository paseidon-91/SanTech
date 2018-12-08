package santech;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

@ManagedBean
public class PanelView {

	@Inject
	private TempBean tempBean;

	public void onClose(CloseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed ", "Closed panel id:'" + event.getComponent().getId() + "'");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onToggle(ToggleEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "  Status:" + event.getVisibility().name() + tempBean.getTestMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}