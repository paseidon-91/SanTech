package santech.controller;

import santech.model.User;
import santech.service.SanTechUserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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

	public List<User> getAllUser(){
		return sanTechUserService.getAllUsers();
	}
}
