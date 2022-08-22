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

import br.com.clinica.clinica.entity.ExamesEntity;
import br.com.clinica.clinica.service.ExameService;

@RestController
@CrossOrigin
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    ExameService exameService;
    @PostMapping("/salvar")
    public ResponseEntity<ExamesEntity> saveExame(@RequestBody ExamesEntity exame) {
        return ResponseEntity.status(HttpStatus.OK).body(exameService.save(exame));
    }
    @GetMapping("todos")
    public ResponseEntity<List<ExamesEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(exameService.findAll());
    }
    
}
