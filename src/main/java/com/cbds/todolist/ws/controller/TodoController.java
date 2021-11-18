package com.cbds.todolist.ws.controller;

import com.cbds.todolist.core.service.TodoService;
import com.cbds.todolist.ws.contract.TodoContract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
public class TodoController implements TodoContract {

    @Autowired
    HttpServletRequest request;

    @Autowired
    private TodoService todoService;

    @Override
    public ResponseEntity<?> adicionar(@RequestBody Map<String, Object> params) {
        try {
            return ResponseEntity.ok(this.todoService.adicionar(params.get("titulo").toString()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> atualizar(@PathVariable Long id,  @RequestBody Map<String, Object> params){
        try {
            return ResponseEntity.ok(this.todoService.atualizar(id, params));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> listar(){
        try {
            return ResponseEntity.ok(this.todoService.listar());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> remover(@PathVariable Long id){
        try {
            this.todoService.remover(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERRO" + e.getMessage());
        }
    }

}
