package com.mayanke7.DAOApplication.dao.impl;

import com.mayanke7.DAOApplication.dao.testSampleObj.AuthorSample;
import com.mayanke7.DAOApplication.domain.Author;
import org.junit.jupiter.api.Test;
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
public class AuthorDaoImplIntegrationTests {

    private AuthorDaoImpl authorDaoTest;


    @Autowired
    public AuthorDaoImplIntegrationTests(AuthorDaoImpl authorDaoImpl){
        this.authorDaoTest= authorDaoImpl;
    }
    @Test
    public void testThatCreteAndReadOne(){
        Author author= AuthorSample.createSampleAuthor();
        authorDaoTest.create(author);
        Optional<Author> authorList= authorDaoTest.findOne(author.getId());
        assertThat(authorList).isPresent();
        assertThat(authorList.get()).isEqualTo(author);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedOrRecalled(){
        List<Author> authorList= AuthorSample.createSampleAuthorList();
        for(Author curAuthor: authorList){
            authorDaoTest.create(curAuthor);
        }

        List<Author> resultAuthorList= authorDaoTest.find();
        assertThat(resultAuthorList).isEqualTo(authorList);
    }

    @Test
    public void testThatMultipleAuthorsCanBeUpdatedAndRecalled(){
        List<Author> authorList= AuthorSample.createSampleAuthorList();
        for(Author curAuthor: authorList){
            authorDaoTest.create(curAuthor);
        }


        //update
        int emailCount=1;
        for(Author author: authorList){
            author.setEmail("ttt@ttt.com"+ emailCount++);
            author.setId(author.getId()+ 55L);
            authorDaoTest.update(author.getId()- 55L, author);
        }

        List<Author> resultAuthorList= authorDaoTest.find();
        assertThat(resultAuthorList).isEqualTo(authorList);
    }

    @Test
    public void testThatAuthorsCanBeCreatedAndDeleted(){
        Author author= AuthorSample.createSampleAuthor();
        authorDaoTest.create(author);
        Optional<Author> authorFetched= authorDaoTest.findOne(author.getId());
        assertThat(authorFetched).isPresent();
        authorDaoTest.delete(author.getId());
        authorFetched= authorDaoTest.findOne(author.getId());
        assertThat(authorFetched).isNotPresent();
    }
}
