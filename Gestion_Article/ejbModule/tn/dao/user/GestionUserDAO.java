package tn.dao.user;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import tn.dto.UserDTO;
import tn.helper.UserHelper;
import tn.model.User;

/**
 * Session Bean implementation class GestionUserDAO
 */
@Stateless
@LocalBean
public class GestionUserDAO implements GestionUserDAOLocal {

    /**
     * Default constructor. 
     */
  @PersistenceContext 
   EntityManager em;
  
	@Override
	public List<User> getAllUser() {
		 return (List<User>)em.createNamedQuery("user.getAllUser").getResultList();
	}

	@Override
	public void addUser(User user) {
		em.persist(user);		
	}

	@Override
	public void updateUser(User user) {
		
		User a1 = em.find(User.class, user.getLogin());
		a1.setEmail(user.getEmail());
		a1.setNom(user.getNom());
		a1.setPassword(user.getPassword());
		a1.setPrenom(user.getPrenom());
		a1.setRole_user(user.getRole_user());
		em.persist(a1);
		
		
	}
    
	@Override
	public boolean findUser(String login, String password, UserDTO user) {
		
		 Query query = em.createNamedQuery("user.findUser");
		    query.setParameter("login", login);
		    query.setParameter("password", password);
		    if(query.getResultList().size()>0)
		    {
		    	user.setNom(UserHelper.modelToDto((User) query.getResultList().get(0)).getNom());
		    	user.setNom(UserHelper.modelToDto((User) query.getResultList().get(0)).getPrenom());
		    	return true;
		    }
		    else
		    	return false;
	}

	@Override
	public void deleteUser(User user) {
		if (em.find(User.class, user.getLogin()) != null)
			em.remove(em.find(User.class,user.getLogin()));
		
	}

	@Override
	public User returnUser(String login, String password) {

		 Query query = em.createNamedQuery("user.findUser");
		    query.setParameter("login", login);
		    query.setParameter("password", password);
		    if(query.getResultList().size()>0)
		    	
		    return  (User)query.getResultList().get(0);
		    else return null;
	}

}
