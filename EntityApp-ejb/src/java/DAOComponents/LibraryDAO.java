/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOComponents;

import EntityModels.Author;
import EntityModels.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Piotr
 */
@Stateless
public class LibraryDAO implements LibraryDAOLocal {

    @PersistenceContext(unitName = "EntityApp-ejbPU")
    private EntityManager em;
    // public EntityManager em = Persistence.createEntityManagerFactory("EntityApp-ejbPU").createEntityManager();

    @Override
    public List<Author> getAllAuthors() throws Exception {
        TypedQuery<Author> namedQuery = em.createNamedQuery("Author.findAll", Author.class);
        return namedQuery.getResultList();
    }

    @Override
    public Author addAuthor(Author author) throws Exception {
        em.persist(author); //добавить
        em.flush(); //заканчивает транзакцию
        return author;
    }

    @Override
    public boolean deleteAuthor(int idAuthor) throws Exception {
        em.remove(em.getReference(Author.class, idAuthor));
        return true;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
