package br.com.inter.Investimentos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "investidor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvestidorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpf;

    @ElementCollection
    private List<CompraModel> compras;
}
