package com.mina.todolistjsp.service;

import com.mina.todolistjsp.model.Todo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITodoService {

    List<Todo> getTodosByUser(String user);

    Optional<Todo> getTodoById(Long id);

    void updateTodo(Todo todo);

    void addTodo(String name, String desc, Date targetDate, boolean isDone);

    void deleteTodo(Long id);

    void saveTodo(Todo todo);
}
