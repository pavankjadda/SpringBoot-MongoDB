package com.books;

import com.books.model.Book;
import com.books.service.BookService;
import com.books.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookStoreApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-mongodb-integrationtest.properties")
public class BookStoreMongoDBIntegrationTest
{
    @Autowired
    MockMvc mockMvc;

    /*@Autowired
    BookRepository bookRepository;*/

    @Autowired
    BookService bookService;


    @Test
    public void createPersons_And_GetPersonsTest() throws Exception
    {
        Book book=createBook("Spring Boot Essentials",200,12.23,"Craig");
        mockMvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$[0].title", is(book.getTitle())));
    }

    @Test
    public void whenValidInput_createPerson() throws Exception
    {
        Book book=createBook("Java Edition 9",200,12.23,"Craig");
        mockMvc.perform(post("/books/save_book").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(book)));
        List<Book> retrievedBooks = bookService.findAll();
        for(Book retrievedBook : retrievedBooks)
        {
            if(retrievedBook.getTitle().equals("Java Edition 9"))
                System.out.println("Success");
        }
        //assertThat(retrivedBooks).extracting(Book::getTitle).isEqualTo("Spring Essentials");
    }

    private Book createBook(String title, Integer numberOfPages, Double cost, String author)
    {
        Book book=new Book(title,numberOfPages,cost,author);
        bookService.insertBook(book);
        return book;
    }

    @Test
    public void getBook()
    {
        System.out.println("Book with id: 5b68baab7ab51f15c19908c6 ==>"+bookService.findById("5b68baab7ab51f15c19908c6"));
        System.out.println("Book with id: 0 ==> "+bookService.findById("0"));
    }


    @Test
    public void getAllBooks()
    {
        List<Book>  books=bookService.findAll();
        for (Book book : books)
        {

            System.out.println("Book: " + book);
        }

    }

    @Test
    public void deleteBookById()
    {
        bookService.deleteById("0");
    }

    @Test
    public void deleteAllBooks()
    {
        bookService.deleteAll();
    }

    @Test
    public void updateBook()
    {
        if(bookService.findById("5b69d82cbdae811dade29e31").isPresent())
        {
            Book book=bookService.findById("5b69d82cbdae811dade29e31").get();
            System.out.println("Before Updating Book ==> "+book.toString());
            book.setCost(100.99);
            book.setNumberOfPages(1000);
            book.setAuthor("PJ");
            bookService.updateBook(book);
        }

    }
}
