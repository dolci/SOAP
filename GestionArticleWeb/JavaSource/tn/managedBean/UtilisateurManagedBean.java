package tn.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.CellEditEvent;

import tn.service.ArticleDTO;
import tn.service.GestionArticleService;
import tn.service.GestionArticleWS;
import tn.service.User;
import tn.service.UserDTO;

@ManagedBean
@SessionScoped
public class UtilisateurManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDTO userSession ;
	private User user;
	private List<UserDTO> listUser;
	GestionArticleService service1 = new GestionArticleService();
	GestionArticleWS client = service1.getGestionArticlePort();
	//HttpSession session;
	/**
	 * 
	 * @return
	 */
	public UserDTO getUserSession() {
		if( userSession == null)
			userSession = new UserDTO();
		return userSession;
	}

	public void setUserSession(UserDTO userSession) {
		this.userSession = userSession;
	}
	/**
	 * 
	 */
	@PostConstruct
	public List<UserDTO> getListUser() {
        client = service1.getGestionArticlePort();
		listUser = client.getAllUser().getItem();
		return listUser;
	}
	/**
	 * 
	 * @return
	 */
	public String logout(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
        return "logout";
    }
	public String loginProject()
	{ 
		//RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		/*HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();*/
    if (client.findUser(userSession.getLogin(), userSession.getPassword(),userSession)==true) {
    	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", userSession.getNom());
    	setUser(client.returnUser(userSession.getLogin(), userSession.getPassword()));
    	System.out.println("*********************\n pass ="+userSession.getPrenom()+"\n***********");
    	//session.setAttribute("user", userSession.getLogin()+" "+userSession.getNom());
            return "success";
        } 
        else {
        	message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid Login!  Please Try Again!");
        	 FacesContext.getCurrentInstance().addMessage(null, message);
          
            return "fail";
        }
    
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    

	public void setListUser(List<UserDTO> listUser) {
		this.listUser = listUser;
	}
	
	
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Utilisateur Edited "+
				((UserDTO) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		client.updateUser(((UserDTO) event.getObject()));
		System.out.println("****************"+((UserDTO) event.getObject()).getEmail());
    }
	
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage(" Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	 
	/*public void delete(ClientBanqueDto clt)
	{
		clDao.delete(clt);
		FacesMessage msg = new FacesMessage("Client Deleted ");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		listClt.remove(clt);
	}*/
}
