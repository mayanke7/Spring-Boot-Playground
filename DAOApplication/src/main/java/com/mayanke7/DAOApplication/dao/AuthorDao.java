package com.mayanke7.DAOApplication.dao;

import com.mayanke7.DAOApplication.domain.Author;

import java.util.Optional;

public interface AuthorDao {


    void create(Author author);

    Optional<Author> findOne(long l);
}
