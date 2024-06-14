package com.mayanke7.DAOApplication.dao.impl;


import com.mayanke7.DAOApplication.dao.testSampleObj.AuthorSample;
import com.mayanke7.DAOApplication.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorDaoImpl authorDaoUnderTest;

    @Test
    public void createAuthorGenerateTheCorrectSql(){
        Author author= Author.builder()
                .id(1L)
                .name("abc abc")
                .email("abc@abc.com")
                .build();

        authorDaoUnderTest.create(author);

        verify(jdbcTemplate).update(
                eq("insert into authors (id, name, email) values (?, ?, ?)"),
                eq(1L),
                eq("abc abc"),
                eq("abc@abc.com")
                );
    }

    @Test
    public void testThatFindOneGenerateCorrectSql(){
        authorDaoUnderTest.findOne(1L);

        verify(jdbcTemplate).query(
                eq("select id, name, email from authors where id = ? limit 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFineManyGenerateCorrectSql(){
        List<Author> authorList= authorDaoUnderTest.find();
        verify(jdbcTemplate).query(
                eq("select id, name, email from authors"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any()
        );

    }

    @Test
    public void testThatUpdateGenerateCorrectSql(){
        Author author= AuthorSample.createSampleAuthor();
        authorDaoUnderTest.update(55L, author);

        verify(jdbcTemplate).update("update authors set id = ?, name = ?, email = ? where id = ?",
                author.getId(), author.getName(),author.getEmail(), 55L);

    }

    @Test
    public void testThatDeleteGenerateCorrectSql(){
        authorDaoUnderTest.delete(1L);

        verify(jdbcTemplate).update(
                "delete from authors where id = ?",
                1L
        );
    }

}
