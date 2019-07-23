package com.example.powerx.Dao;

import com.example.powerx.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherDao extends JpaRepository<Publisher,Integer> {
    Publisher findByName(String name);
}
