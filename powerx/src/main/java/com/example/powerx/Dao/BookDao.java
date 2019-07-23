package com.example.powerx.Dao;

import com.example.powerx.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Integer> {
    Book findByName(String name);
}
