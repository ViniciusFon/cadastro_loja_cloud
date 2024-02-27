package com.br.cadastrolojacloud.application.loja.inserir.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LojaEnderecoInserirRequest {

    private String cep;
    private String numero;
    private String complemento;
}
