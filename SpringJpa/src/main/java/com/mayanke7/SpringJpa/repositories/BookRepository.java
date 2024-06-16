package com.mayanke7.SpringJpa.repositories;

import com.mayanke7.SpringJpa.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
