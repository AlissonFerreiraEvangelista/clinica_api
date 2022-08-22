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
@Table(name="tipo_exame")
@EqualsAndHashCode
public class TipoExameEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String tipo;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ExamesEntity> exames;

}
