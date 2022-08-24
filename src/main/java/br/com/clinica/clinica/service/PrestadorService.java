package br.com.clinica.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinica.clinica.entity.PrestadorEntity;
import br.com.clinica.clinica.repository.PrestadorRepository;

@Service
public class PrestadorService {

    @Autowired
    PrestadorRepository prestadorRepository;

    @Transactional
    public PrestadorEntity save(PrestadorEntity prestadorEntity){
        return prestadorRepository.save(prestadorEntity);
    }

    public List<PrestadorEntity> findAll(){
        return prestadorRepository.findAll();
    }

    


    
}
