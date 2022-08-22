package br.com.clinica.clinica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;


import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class ClienteEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String cnpj;
    String nomeFantasia;
    String endereco;
    String telefone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cliente")
    @JsonIgnore
    private List<FuncionarioEntity> funcionario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "cliente_exames",joinColumns = {@JoinColumn(name = "id_clientes") },
    inverseJoinColumns = { @JoinColumn(name = "id_exames") })
    @JsonIgnore
    List<ExamesEntity> exames;



    
    
}
