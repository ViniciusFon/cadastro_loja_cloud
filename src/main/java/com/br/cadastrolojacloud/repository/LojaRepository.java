package com.br.cadastrolojacloud.repository;

import com.br.cadastrolojacloud.domain.PotenciaEnum;
import com.br.cadastrolojacloud.domain.loja.Loja;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LojaRepository extends MongoRepository<Loja, String>{

    public Optional<Loja> findByNumeroLojaAndPotencia(Integer numeroLoja, PotenciaEnum potencia);

    public List<Loja> findByNumeroLoja(Integer numeroLoja);

    public Optional<Loja> findByCnpj(String cnpj);

    public List<Loja> findByNome(String nome);

    public List<Loja> findByPotencia(PotenciaEnum potencia);
}
