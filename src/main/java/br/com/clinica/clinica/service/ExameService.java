package br.com.clinica.clinica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.clinica.entity.ExamesEntity;
import br.com.clinica.clinica.repository.ExameRepository;

@Service
public class ExameService {

    @Autowired
    ExameRepository exameRepository;

    @Transactional
    public ExamesEntity save(ExamesEntity examesEntity){
        return exameRepository.save(examesEntity);
    }

    public List<ExamesEntity> findAll(){
        return exameRepository.findAll();
    }
    
}
