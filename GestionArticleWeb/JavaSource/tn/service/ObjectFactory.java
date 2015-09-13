
package tn.service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tn.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tn.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserDTO }
     * 
     */
    public UserDTO createUserDTO() {
        return new UserDTO();
    }

    /**
     * Create an instance of {@link ArticleDTO }
     * 
     */
    public ArticleDTO createArticleDTO() {
        return new ArticleDTO();
    }

    /**
     * Create an instance of {@link ArticleDTOArray }
     * 
     */
    public ArticleDTOArray createArticleDTOArray() {
        return new ArticleDTOArray();
    }

    /**
     * Create an instance of {@link UserDTOArray }
     * 
     */
    public UserDTOArray createUserDTOArray() {
        return new UserDTOArray();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

}
