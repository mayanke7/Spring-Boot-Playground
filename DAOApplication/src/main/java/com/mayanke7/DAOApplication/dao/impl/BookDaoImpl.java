package com.mayanke7.DAOApplication.dao.impl;

import com.mayanke7.DAOApplication.dao.BookDao;
import com.mayanke7.DAOApplication.domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class BookDaoImpl implements BookDao {

    private final JdbcTemplate jdbcTemplate;
    public BookDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }


    @Override
    public void create(Book book) {
        jdbcTemplate.update("insert into books (isbn, author_id, title) values (?, ?, ?)",
                book.getIsbn(), book.getAuthorId(), book.getTitle());
    }
}
