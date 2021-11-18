package com.cbds.todolist.core.repository;

import com.cbds.todolist.core.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
