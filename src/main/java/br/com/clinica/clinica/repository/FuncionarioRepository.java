package br.com.clinica.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinica.clinica.entity.FuncionarioEntity;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>{
    
    @Modifying
	@Transactional
	@Query(value="SELECT f FROM FuncionarioEntity f WHERE f.exame.nomeExame = ?1")
    public List<FuncionarioEntity> getPorExames(String exame);
    
}
