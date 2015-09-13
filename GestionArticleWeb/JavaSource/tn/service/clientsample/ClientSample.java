package tn.service.clientsample;

import tn.service.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        GestionArticleService service1 = new GestionArticleService();
	        System.out.println("Create Web Service...");
	        GestionArticleWS port1 = service1.getGestionArticlePort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.returnUser(null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: port1.deleteUser() is a void method!");
	        System.out.println("Server said: " + port1.getAllUser());
	        System.out.println("Server said: port1.updateUser() is a void method!");
	        System.out.println("Server said: " + port1.findUser(null,null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: port1.addArticle() is a void method!");
	        System.out.println("Server said: port1.updateArticle() is a void method!");
	        System.out.println("Server said: " + port1.getAllArticle());
	        System.out.println("Server said: port1.deleteArticle() is a void method!");
	        System.out.println("Create Web Service...");
	        GestionArticleWS port2 = service1.getGestionArticlePort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.returnUser(null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: port2.deleteUser() is a void method!");
	        System.out.println("Server said: " + port2.getAllUser());
	        System.out.println("Server said: port2.updateUser() is a void method!");
	        System.out.println("Server said: " + port2.findUser(null,null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: port2.addArticle() is a void method!");
	        System.out.println("Server said: port2.updateArticle() is a void method!");
	        System.out.println("Server said: " + port2.getAllArticle());
	        System.out.println("Server said: port2.deleteArticle() is a void method!");
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
