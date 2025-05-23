package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Todo;
import com.example.repository.TodoRepo;

@Service
public class TodoService {
	@Autowired
	private TodoRepo todoRepository;
	
	public Todo addTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }


    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

	public String summarizeTodos() {
		return null;
	}
}
