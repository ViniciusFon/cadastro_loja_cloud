package com.br.cadastrolojacloud.domain.loja;

import com.br.cadastrolojacloud.domain.PotenciaEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "loja")
@NoArgsConstructor
public class Loja {

    @Id
    private String id;
    private Integer numeroLoja;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private String cnpj;
    private PotenciaEnum potencia;
    private LocalDate dataFunacao;
}
