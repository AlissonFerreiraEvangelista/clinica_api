package br.com.clinica.clinica.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.clinica.clinica.entity.ClienteEntity;
import br.com.clinica.clinica.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity save(ClienteEntity clienteEntity){
        return clienteRepository.save(clienteEntity);
    }

    public List<ClienteEntity> findAll(){
        return clienteRepository.findAll();
    }
    
}
