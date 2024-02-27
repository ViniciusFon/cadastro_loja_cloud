package com.br.cadastrolojacloud.application.loja.inserir;

import com.br.cadastrolojacloud.application.loja.inserir.request.LojaInserirRequest;
import com.br.cadastrolojacloud.application.loja.inserir.response.LojaEnderecoInserirResponse;
import com.br.cadastrolojacloud.application.loja.inserir.response.LojaInserirResponse;
import com.br.cadastrolojacloud.client.viacep.ViaCepClient;
import com.br.cadastrolojacloud.client.viacep.response.AddressResponse;
import com.br.cadastrolojacloud.domain.loja.Endereco;
import com.br.cadastrolojacloud.domain.loja.Loja;
import com.br.cadastrolojacloud.repository.LojaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class LojaInserirServiceImpl implements LojaInserirService{


    private LojaRepository lojaRepository;

    private ViaCepClient viaCepClient;

    @Override
    public LojaInserirResponse inserir(LojaInserirRequest request) {

        Loja loja = new Loja();
        BeanUtils.copyProperties(request, loja);
        loja.setId(UUID.randomUUID().toString());

        AddressResponse address = viaCepClient.getAddress(request.getEndereco().getCep());

        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(address, endereco);
        endereco.setNumero(request.getEndereco().getNumero());
        endereco.setComplemento(request.getEndereco().getComplemento());
        loja.setEndereco(endereco);

        lojaRepository.save(loja);

        LojaInserirResponse response = new LojaInserirResponse();
        BeanUtils.copyProperties(loja, response);
        LojaEnderecoInserirResponse enderecoResponse = new LojaEnderecoInserirResponse();
        BeanUtils.copyProperties(loja.getEndereco(), enderecoResponse);
        response.setEndereco(enderecoResponse);

        return response;

    }

}
