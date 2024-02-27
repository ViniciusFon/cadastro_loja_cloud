package com.br.cadastrolojacloud.application.loja.buscar.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LojaEnderecoBuscarResponse {

    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
