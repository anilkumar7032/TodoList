package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

}
