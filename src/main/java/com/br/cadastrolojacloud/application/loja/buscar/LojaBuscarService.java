package com.br.cadastrolojacloud.application.loja.buscar;

import com.br.cadastrolojacloud.application.loja.buscar.response.LojaBuscarResponse;
import com.br.cadastrolojacloud.domain.PotenciaEnum;

import java.util.List;

public interface LojaBuscarService {

    LojaBuscarResponse buscar(String id);

    LojaBuscarResponse buscarPorNumeroEPotencia(Integer numero, PotenciaEnum potencia);

    List<LojaBuscarResponse> buscarPorPotencia(PotenciaEnum potencia);

}
