package com.cbds.todolist.core.service;


import com.cbds.todolist.core.model.Todo;
import com.cbds.todolist.core.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TodoService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private TodoRepository todoRepository;


    public Todo adicionar( String titulo ) {
        Todo todo = new Todo();
        todo.setTitulo(titulo);
        return todoRepository.save(todo);
    }

    public List<Todo> listar() {
        return (List<Todo>) todoRepository.findAll();
    }

    public void remover( Long id ) throws Exception {
        if (this.todoRepository.existsById(id)){
            this.todoRepository.deleteById(id);
        }else{
            throw new Exception("ID:" + id + " Não encontrado");
        }
    }

    public Todo atualizar(Long id, Map<String, Object> dados ) throws Exception {

        Todo todo = this.todoRepository.findById(id)
                .orElseThrow(() -> new Exception("ID:" + id + " Não encontrado"));

        todo.setTitulo(dados.get("titulo").toString());
        String bool = dados.get("concluido").toString();
        todo.setConcluido(Boolean.parseBoolean(bool));
        todoRepository.save(todo);
        return todo;
    }




}