package com.cbds.todolist.ws.contract;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("${todolist.request.mapping.domain}")
public interface TodoContract {

    @CrossOrigin
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> adicionar(@RequestBody Map<String, Object> params);

    @CrossOrigin
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> listar();

    @CrossOrigin
    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Map<String, Object> params);

    @CrossOrigin
    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> remover(@PathVariable Long id);
}
