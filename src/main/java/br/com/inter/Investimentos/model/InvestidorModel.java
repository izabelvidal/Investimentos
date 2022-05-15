package br.com.inter.Investimentos.model;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "Todas compras efetuadas pela investidor de determinado id")
    @ElementCollection
    private List<CompraModel> compras;
}
