package br.com.clinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.clinica.clinica.entity.FuncionarioEntity;
import br.com.clinica.clinica.service.FuncionarioService;

@RestController
@CrossOrigin
@RequestMapping({"/funcionario"})
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/salvar")
    public ResponseEntity<FuncionarioEntity> saveFuncionario(@RequestBody FuncionarioEntity funcionario) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
    }
    @GetMapping("todos")
    public ResponseEntity<List<FuncionarioEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }
    
}
