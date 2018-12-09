package santech.controller;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;
import santech.TempBean;
import santech.model.User;
import santech.service.SanTechUserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandr
 */

@Named
@SessionScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = -963460422133145312L;

	@Inject
	private SanTechUserService sanTechUserService;

	private List<User> userList;
	private List<User> filterUserList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<User> getFilterUserList() {
		return filterUserList;
	}

	public void setFilterUserList(List<User> filterUserList) {
		this.filterUserList = filterUserList;
	}

	@PostConstruct
	public void init(){
		filterUserList = new ArrayList<>();
		userList = sanTechUserService.getAllUsers();
	}
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
