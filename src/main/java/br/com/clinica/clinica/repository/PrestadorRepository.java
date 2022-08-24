package br.com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.clinica.entity.PrestadorEntity;

@Repository
public interface PrestadorRepository extends JpaRepository<PrestadorEntity,Long>{
    
}
