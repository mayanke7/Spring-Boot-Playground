package com.mayanke7.DAOApplication.dao.impl;

import com.mayanke7.DAOApplication.dao.AuthorDao;
import com.mayanke7.DAOApplication.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update(
                "insert into authors (id, name, email) values (?, ?, ?)",
                author.getId(),
                author.getName(),
                author.getEmail()
        );
    }

    @Override
    public Optional<Author> findOne(long id) {
        List<Author> authors= jdbcTemplate.query("select id, name, email from authors where id = ? limit 1",
                new AuthorRowMapper(),
                id);
        return authors.stream().findFirst();
    }

    public static class AuthorRowMapper implements RowMapper<Author>{


        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Author.builder()
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .id(rs.getLong("id"))
                    .build();
        }
    }
}
