package com.br.cadastrolojacloud.application.loja.buscar;

import com.br.cadastrolojacloud.application.loja.buscar.response.LojaBuscarResponse;
import com.br.cadastrolojacloud.application.loja.buscar.response.LojaEnderecoBuscarResponse;
import com.br.cadastrolojacloud.application.loja.inserir.response.LojaEnderecoInserirResponse;
import com.br.cadastrolojacloud.domain.PotenciaEnum;
import com.br.cadastrolojacloud.domain.loja.Loja;
import com.br.cadastrolojacloud.repository.LojaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LojaBuscarServiceImpl implements LojaBuscarService{


    private final LojaRepository lojaRepository;

    @Override
    public LojaBuscarResponse buscar(String id) {

        Loja loja = lojaRepository.findById(id).orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        LojaBuscarResponse response = new LojaBuscarResponse();
        BeanUtils.copyProperties(loja,response);
        LojaEnderecoBuscarResponse enderecoResponse = new LojaEnderecoBuscarResponse();
        BeanUtils.copyProperties(loja.getEndereco(), enderecoResponse);
        response.setEndereco(enderecoResponse);

        return response;
    }

    @Override
    public LojaBuscarResponse buscarPorNumeroEPotencia(Integer numero, PotenciaEnum potencia) {

        Loja loja = lojaRepository.findByNumeroLojaAndPotencia(numero, potencia).orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        LojaBuscarResponse response = new LojaBuscarResponse();
        BeanUtils.copyProperties(loja,response);
        LojaEnderecoBuscarResponse enderecoResponse = new LojaEnderecoBuscarResponse();
        BeanUtils.copyProperties(loja.getEndereco(), enderecoResponse);
        response.setEndereco(enderecoResponse);

        return response;
    }

    @Override
    public List<LojaBuscarResponse> buscarPorPotencia(PotenciaEnum potencia) {

        List<Loja> lojas = lojaRepository.findByPotencia(potencia);
        List<LojaBuscarResponse> response = new ArrayList<>();

        return lojas.stream().map(loja -> {
            LojaBuscarResponse lojaResponse = new LojaBuscarResponse();
            BeanUtils.copyProperties(loja,lojaResponse);
            LojaEnderecoBuscarResponse enderecoResponse = new LojaEnderecoBuscarResponse();
            BeanUtils.copyProperties(loja.getEndereco(), enderecoResponse);
            lojaResponse.setEndereco(enderecoResponse);
            return lojaResponse;
        }).toList();

    }
}
