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

import br.com.clinica.clinica.entity.ClienteEntity;
import br.com.clinica.clinica.service.ClienteService;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/salvar")
    public ResponseEntity<ClienteEntity> saveCliente(@RequestBody ClienteEntity cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }
    @GetMapping("todos")
    public ResponseEntity<List<ClienteEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    
}
