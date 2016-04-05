/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOComponents;

import EntityModels.Author;
import EntityModels.Book;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Piotr
 */
@Local
public interface LibraryDAOLocal {
    public List<Author> getAllAuthors() throws Exception;
    public  Author addAuthor(Author author) throws Exception;
    public boolean deleteAuthor(int idAuthor) throws Exception;
    public List<Book> getAllBooks() throws Exception;
}
