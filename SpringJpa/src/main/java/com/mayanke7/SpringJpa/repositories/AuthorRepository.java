package com.mayanke7.SpringJpa.repositories;

import com.mayanke7.SpringJpa.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    public Iterable<Author> idLessThan(Long id);


    @Query("select a from Author a where a.id > ?1")
    public Iterable<Author> idMoreThan(Long id);
}
