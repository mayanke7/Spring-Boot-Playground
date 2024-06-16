package com.mayanke7.SpringJpa.repositories;

import com.mayanke7.SpringJpa.TestUtil.SampleClasses;
import org.junit.jupiter.api.Test;
import com.mayanke7.SpringJpa.domain.Author;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorIntegrationTests {

    private final AuthorRepository authorRepositoryUnderTest;
    @Autowired
    public AuthorIntegrationTests(final AuthorRepository authorRepositoryUnderTest){
        this.authorRepositoryUnderTest= authorRepositoryUnderTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled(){

        Author sampleAuthor = SampleClasses.createSampleAuthor();

        Author savedAuthor = authorRepositoryUnderTest.save(sampleAuthor);
        Long id = savedAuthor.getId();
        Optional<Author> retrievedAuthor = authorRepositoryUnderTest.findById(id);

        assertThat(retrievedAuthor).isPresent();
        assertThat(retrievedAuthor.get()).isEqualTo(savedAuthor);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        List<Author> authorList = SampleClasses.createSampleAuthorList();

        for (Author author : authorList) {
            Author savedAuthor = authorRepositoryUnderTest.save(author);
            Long id = savedAuthor.getId();
            Optional<Author> retrievedAuthor = authorRepositoryUnderTest.findById(id);

            assertThat(retrievedAuthor).isPresent();
            assertThat(retrievedAuthor.get()).isEqualTo(savedAuthor);
        }
    }

    @Test
    public void testThatMultipleAuthorsCanBeRecalled(){
        List<Author> authorList = SampleClasses.createSampleAuthorList();

        List<Author> savedAuthors= new ArrayList<>();
        for (Author author : authorList) {
            Author savedAuthor = authorRepositoryUnderTest.save(author);
            savedAuthors.add(savedAuthor);
        }

        Iterable<Author> result= authorRepositoryUnderTest.findAll();

        for(Author author : savedAuthors){
            assertThat(author).isIn(result);
        }
    }

    @Test
    public void testThatAuthorsIdLessThanCanBeRecalled(){
        Iterable<Author> result= authorRepositoryUnderTest.idLessThan(250L);
        for(Author author : result){
            assertThat(author.getId()).isLessThan(250L);
        }
    }

    @Test
    public void testThatAuthorsIdGreaterThanCanBeRecalled(){
        Iterable<Author> result= authorRepositoryUnderTest.idMoreThan(250L);
        for(Author author : result){
            assertThat(author.getId()).isGreaterThan(250L);
        }
    }


}
