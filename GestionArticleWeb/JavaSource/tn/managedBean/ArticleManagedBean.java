package tn.managedBean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import tn.service.ArticleDTO;
import tn.service.GestionArticleService;
import tn.service.GestionArticleWS;

@ManagedBean
@SessionScoped
public class ArticleManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ArticleDTO> listArticle;

	private ArticleDTO selectedArticle;
	GestionArticleWS client;
	
	private String message;
	
	 static String mess_modif_true = "Modification effectuée avec succès";
	 static String mess_insert_true = "Ajout effectué avec succès";
	 static String mess_op_false = "Opération échouée";
	 static String mess_del_true = "Suppression effectuée avec succès";
	 String style_message;
	@PostConstruct
	public void init()
	{
		selectedArticle = new ArticleDTO();
	}
	@PostConstruct
	public List<ArticleDTO> getListArticle()
	{
	
		GestionArticleService service1 = new GestionArticleService();
	    client = service1.getGestionArticlePort();
		listArticle = client.getAllArticle().getItem();
		//selectedArticle = new ArticleDTO();
	return listArticle;
	}
	
	public void setListArticle(List<ArticleDTO> listArticle) {
		this.listArticle = listArticle;
	}

	
	public ArticleDTO getSelectedArticle() {
		return selectedArticle;
	}

	public void setSelectedArticle(ArticleDTO selectedArticle) {
		/*if(selectedArticle!=null)
		System.out.println("tttttttttttttt"+selectedArticle.getLibelle());*/
		this.selectedArticle = selectedArticle;
	}
    
	public void update() {

        try {
        	 
             client.updateArticle(selectedArticle);           
             setMessage(mess_modif_true);
             style_message = "valid_message";
         //    System.out.println("\n ******* update \n ***********");
     		
        } catch (Exception hx) {
            hx.printStackTrace();
            setMessage(mess_op_false);
            style_message = "err_message";

        }

        viderchamps();
    }
	public void onRowSelect(SelectEvent event) {
        
    }
 
    public void onRowUnselect(UnselectEvent event) {
        
    }
	public void annuler() {
        setMessage("");
        

        viderchamps();
    }
	public void viderchamps() {
        setMessage("");
        selectedArticle  = new ArticleDTO();

    }
	public void showmsg(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
       
        context.addMessage(null, new FacesMessage(" ", " " + mess_modif_true));

    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
     
	 public void supprimer() {
	        try {
	            client.deleteArticle(selectedArticle);
	            message = mess_del_true;
	            style_message = "valid_message";
	           
	        } catch (Exception hx) {
	            hx.printStackTrace();
	            message = mess_op_false;
	        }
	    }

	public void createArticle()
	{
		client.addArticle(selectedArticle);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "saved",selectedArticle.getLibelle()));
	}
    

}
