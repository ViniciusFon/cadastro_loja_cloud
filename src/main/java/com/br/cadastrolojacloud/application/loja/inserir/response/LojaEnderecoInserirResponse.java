package com.br.cadastrolojacloud.application.loja.inserir.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LojaEnderecoInserirResponse {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
