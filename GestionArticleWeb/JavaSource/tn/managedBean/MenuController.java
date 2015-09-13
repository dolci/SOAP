package tn.managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="menuController")
@ViewScoped
public class MenuController implements Serializable {

    /**
	 * 
	 */
	static String page = "Articles";
	private static final long serialVersionUID = 1L;

	/**
     * Creates a new instance of menuController
     */
    public MenuController() {}
    
     /** === Getter / Setter === **/
    
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        MenuController.page = page;
    }    
   
    public void doViewListUtilisateur() {
        MenuController.page = "ListUtilisateur";
    }
   
    public void doViewUtilisateur() {
        MenuController.page = "AddUtilisateur";
    }
    public void doViewListArticles() {
        MenuController.page = "Articles";
    }
    public void doViewAddArticles() {
        MenuController.page = "AddArticle";
    }
    
    

    
  
    
}
