package com.br.cadastrolojacloud.application.loja.inserir.request;

import com.br.cadastrolojacloud.domain.PotenciaEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LojaInserirRequest {

    private Integer numeroLoja;
    private String nome;
    private LojaEnderecoInserirRequest endereco;
    private String telefone;
    private String cnpj;
    private PotenciaEnum potencia;
    private LocalDate dataFunacao;
}
