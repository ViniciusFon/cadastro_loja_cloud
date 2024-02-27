package com.br.cadastrolojacloud.application.loja.buscar.response;

import com.br.cadastrolojacloud.domain.PotenciaEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LojaBuscarResponse {

    private String id;
    private Integer numeroLoja;
    private String nome;
    private LojaEnderecoBuscarResponse endereco;
    private String telefone;
    private String cnpj;
    private PotenciaEnum potencia;
    private LocalDate dataFunacao;
}
