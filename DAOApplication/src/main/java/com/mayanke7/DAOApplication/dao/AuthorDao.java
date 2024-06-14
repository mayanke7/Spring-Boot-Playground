package com.mayanke7.DAOApplication.dao;

import com.mayanke7.DAOApplication.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao {


    void create(Author author);

    Optional<Author> findOne(long l);

    List<Author> find();

    void update(long l, Author author);

    void delete(long l);
}
