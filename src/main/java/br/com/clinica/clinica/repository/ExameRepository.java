package br.com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.clinica.entity.ExamesEntity;

@Repository
public interface ExameRepository extends JpaRepository<ExamesEntity, Long>{
    
}
