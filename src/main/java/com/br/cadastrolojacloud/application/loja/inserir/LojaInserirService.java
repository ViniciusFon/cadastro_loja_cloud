package com.br.cadastrolojacloud.application.loja.inserir;

import com.br.cadastrolojacloud.application.loja.inserir.request.LojaInserirRequest;
import com.br.cadastrolojacloud.application.loja.inserir.response.LojaInserirResponse;

public interface LojaInserirService {

        LojaInserirResponse inserir(LojaInserirRequest request);
}
