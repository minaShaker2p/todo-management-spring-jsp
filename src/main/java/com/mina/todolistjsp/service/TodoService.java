package com.mina.todolistjsp.service;

import com.mina.todolistjsp.model.Todo;
import com.mina.todolistjsp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodosByUser(String user) {
        return todoRepository.findByUserName(user);
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todoRepository.save(new Todo(name, desc, targetDate, isDone));
    }

    @Override
    public void deleteTodo(Long id) {

        Optional<Todo> todo = todoRepository.findById(id);
        todo.ifPresent(value -> todoRepository.delete(value));

    }

    @Override
    public void saveTodo(Todo todo) {
        todoRepository.save(todo);

    }
}
