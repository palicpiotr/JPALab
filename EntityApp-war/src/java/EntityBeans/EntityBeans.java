/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import DAOComponents.LibraryDAOLocal;
import EntityModels.Author;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Piotr
 */
@Named(value = "entityBeans")
@RequestScoped
public class EntityBeans {
   
    @EJB
    private LibraryDAOLocal library;
    
    @PostConstruct
    private void initializeBean(){
        author = new Author();
    }
    
    private Author author;

    private int idAuthor;

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
    
    
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
    public List<Author> getAllAuthors() throws Exception{
        return library.getAllAuthors();
    }
    
    public String addAuthor() throws Exception{
       this.library.addAuthor(author);
       return "/Authors.xhtml";
    }
    
    public void deleteAuthor(int idAuthor) throws Exception{
       library.deleteAuthor(idAuthor);        
    }
}
