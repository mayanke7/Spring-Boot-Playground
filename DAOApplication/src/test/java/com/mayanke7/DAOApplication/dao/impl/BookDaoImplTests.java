package com.mayanke7.DAOApplication.dao.impl;

import com.mayanke7.DAOApplication.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {


    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl bookDaoUnderTests;

    @Test
    public void createBookGenerateSqlTest(){
        Book book= Book.builder()
                .authorId(1L)
                .isbn("564thfgr")
                .title("Morning starbvfgfrthdvc bfegdf")
                .build();

        bookDaoUnderTests.create(book);
        Mockito.verify(jdbcTemplate).update(
                eq("insert into books (isbn, author_id, title) values (?, ?, ?)"),
                eq("564thfgr"),
                eq(1L),
                eq("Morning starbvfgfrthdvc bfegdf")
        );
    }

}
