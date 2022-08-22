package br.com.clinica.clinica.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "resultado_exame")
@EqualsAndHashCode
public class ResultadoExameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String aso;
    String fco;
    String guia;
    String tudoOk;

    @OneToMany(mappedBy = "resultado", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExamesEntity> exames;

}
