package com.mayanke7.DAOApplication.dao.impl;


import com.mayanke7.DAOApplication.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;


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

        Mockito.verify(jdbcTemplate).update(
                eq("insert into authors (id, name, email) values (?, ?, ?)"),
                eq(1L),
                eq("abc abc"),
                eq("abc@abc.com")
                );
    }

    @Test
    public void testThatFindOneGenerateCorrectSql(){
        authorDaoUnderTest.findOne(1L);

        Mockito.verify(jdbcTemplate).query(
                eq("select id, name, email from authors where id = ? limit 1"),
                ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
                eq(1L)
        );
    }

}
