package com.mayanke7.SpringJpa.repositories;


import com.mayanke7.SpringJpa.TestUtil.SampleClasses;
import com.mayanke7.SpringJpa.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.mayanke7.SpringJpa.domain.Author;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookIntegrationTests {
    private final BookRepository bookRepositoryUnderTest;

    @Autowired
    public BookIntegrationTests(BookRepository bookRepository){
        this.bookRepositoryUnderTest= bookRepository;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled(){
        Author author= SampleClasses.createSampleAuthor();
        Book book= SampleClasses.createSampleBook(author);
        Book resultBook = bookRepositoryUnderTest.save(book);
        Optional<Book> result= bookRepositoryUnderTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(resultBook);
    }

    @Test
    public void testThatBooksCanBeUpdated(){
        Author author= SampleClasses.createSampleAuthor();
        Book book= SampleClasses.createSampleBook(author);
        Optional<Book> resultBook= bookRepositoryUnderTest.findById(book.getIsbn());
        Book savedBook;
        if(resultBook.isEmpty()){
            savedBook= bookRepositoryUnderTest.save(book);
        }else{
            savedBook= resultBook.get();
        }

        savedBook.setTitle("The Alchemist");
        Author savedAuthor= savedBook.getAuthor();
        savedAuthor.setName("Mayank Sinha");
        savedBook.setAuthor(savedAuthor);

        Book updatedBook= bookRepositoryUnderTest.save(savedBook);

        assertThat(updatedBook).isEqualTo(savedBook);
    }

    @Test
    public void testThatBooksCanBeDeleted(){
        Author author= SampleClasses.createSampleAuthor();
        Book book= SampleClasses.createSampleBook(author);
        Optional<Book> resultBook= bookRepositoryUnderTest.findById(book.getIsbn());
        Book savedBook;
        if(resultBook.isEmpty()){
            savedBook= bookRepositoryUnderTest.save(book);
        }else{
            savedBook= resultBook.get();
        }

        bookRepositoryUnderTest.delete(savedBook);
        resultBook= bookRepositoryUnderTest.findById(book.getIsbn());

        assertThat(resultBook).isNotPresent();
    }



}
