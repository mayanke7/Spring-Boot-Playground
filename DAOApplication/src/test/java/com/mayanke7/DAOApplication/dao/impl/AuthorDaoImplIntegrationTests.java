package com.mayanke7.DAOApplication.dao.impl;

import com.mayanke7.DAOApplication.dao.testSampleObj.AuthorSample;
import com.mayanke7.DAOApplication.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
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
}
