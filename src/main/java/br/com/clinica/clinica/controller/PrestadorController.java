package br.com.clinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinica.clinica.entity.PrestadorEntity;
import br.com.clinica.clinica.service.PrestadorService;

@RestController
@CrossOrigin
@RequestMapping("/prestador")
public class PrestadorController {

    @Autowired
    PrestadorService prestadorService;

    @PostMapping("/salvar")
    public ResponseEntity<PrestadorEntity>savePrestador(@RequestBody PrestadorEntity prestadorEntity){
        return ResponseEntity.status(HttpStatus.OK).body(prestadorService.save(prestadorEntity));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PrestadorEntity>>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(prestadorService.findAll());
    }

    @PutMapping("/atualiza")
    public ResponseEntity<PrestadorEntity>update(@RequestBody PrestadorEntity prestadorEntity){
        return ResponseEntity.status(HttpStatus.OK).body(prestadorService.save(prestadorEntity));

    }
    
}
