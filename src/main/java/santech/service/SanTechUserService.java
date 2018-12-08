package santech.service;

import santech.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alexandr
 */


@Stateless
public class SanTechUserService implements Serializable {
	private static final long serialVersionUID = -4306646684162608386L;

	@PersistenceContext(unitName = "sanTechPU")
	private EntityManager entityManager;

	public List<User> getAllUsers(){
		return entityManager.createNamedQuery(User.ALL_USER, User.class).getResultList();
	}
}
