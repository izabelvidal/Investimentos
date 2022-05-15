package br.com.inter.Investimentos.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "compra")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "identificacao do comprador")
    @OneToOne
    @JoinColumn(name = "investidor_id")
    private InvestidorModel investidorModel;

    @ApiModelProperty(value = "Quantidade em reais a qual o usuario deseja investir")
    private Double investimento;

    @ApiModelProperty(value = "Numero de empresas na qual o usuario deseja investir")
    private Integer numeroEmpresas;
}
