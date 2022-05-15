package br.com.inter.Investimentos.model;

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

    @OneToOne
    @JoinColumn(name = "investidor_id")
    private InvestidorModel investidorModel;

    private Double investimento;
    private Integer numeroEmpresas;
}
