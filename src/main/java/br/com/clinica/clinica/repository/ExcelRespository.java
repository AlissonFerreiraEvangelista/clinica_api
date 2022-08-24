package br.com.clinica.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.clinica.entity.ExcelEntity;

@Repository
public interface ExcelRespository extends JpaRepository<ExcelEntity, Long>{}
    

