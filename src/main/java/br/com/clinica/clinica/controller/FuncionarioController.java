package br.com.clinica.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.clinica.clinica.entity.FuncionarioEntity;
import br.com.clinica.clinica.repository.FuncionarioRepository;
import br.com.clinica.clinica.service.FuncionarioService;

@RestController
@CrossOrigin
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping("/salvar")
    public ResponseEntity<FuncionarioEntity> saveFuncionario(@RequestBody FuncionarioEntity funcionario) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.save(funcionario));
    }
    @GetMapping("todos")
    public ResponseEntity<List<FuncionarioEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @GetMapping("/exame/")
    public ResponseEntity<Object> listarPorExame(@RequestParam(value = "exame") String exame){
        List<FuncionarioEntity> funcionario = funcionarioRepository.getPorExames(exame);
        if(funcionario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem registro de visita na data informada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

}
