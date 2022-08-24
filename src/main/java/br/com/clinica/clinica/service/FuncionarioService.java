package br.com.clinica.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinica.clinica.entity.FuncionarioEntity;
import br.com.clinica.clinica.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Transactional
    public FuncionarioEntity save(FuncionarioEntity funcionarioEntity){
        return funcionarioRepository.save(funcionarioEntity);
    }

    public List<FuncionarioEntity> findAll(){
        return funcionarioRepository.findAll();
    }

    

    


    
}
