package ite.librarymaster.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ite.librarymaster.model.Book;
import ite.librarymaster.model.BookGenre;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
/* Note that if no file is specified to @ContextConfiguration, it is derived as <classname>-context.xml, 
 * so in this case, it expects to find JdbcBookRepositoryTest-context.xml in the current directory */
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaBookRepositoryTest {
	
	@Autowired
	@Qualifier("jpaBookRepository")
	private BookRepository bookRepository;

	@Test
	public void testGetAllBooks() {
		List<Book> allBooks = bookRepository.findAll();
		assertNotNull(allBooks);
		// Verify number of books returned
		assertEquals(4,allBooks.size());
	}

	@Test
	public void testFindByIsbn() {
		Book book = bookRepository.findByIsbn("9780553382563");
	    assertNotNull(book);
		assertEquals("I, Robot",book.getTitle());
		assertEquals("Random House Inc",book.getPublisher());
		assertEquals("Isaac Asimov",book.getAuthor());
		assertEquals(BookGenre.Scifi,book.getGenre());
	}

}
