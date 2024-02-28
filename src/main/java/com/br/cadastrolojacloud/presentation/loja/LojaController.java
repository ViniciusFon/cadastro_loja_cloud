package com.br.cadastrolojacloud.presentation.loja;

import com.br.cadastrolojacloud.application.loja.buscar.LojaBuscarService;
import com.br.cadastrolojacloud.application.loja.buscar.response.LojaBuscarResponse;
import com.br.cadastrolojacloud.application.loja.inserir.LojaInserirService;
import com.br.cadastrolojacloud.application.loja.inserir.request.LojaInserirRequest;
import com.br.cadastrolojacloud.domain.PotenciaEnum;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaBuscarService lojaBuscarService;

    @Autowired
    private LojaInserirService lojaInserirService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${server.name}")
    private String serverName;

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint que retorna a loja por id")
    public LojaBuscarResponse buscar(@PathVariable("id") String id) {

        return lojaBuscarService.buscar(id);

    }

    @GetMapping("/teste")
    public String teste(){
        return serverName + ": " + serverPort ;
    }

    @GetMapping("/numero/{numero}/potencia/{potencia}")
    @Operation(summary = "Endpoint que retorna a loja por numero e potencia")
    public LojaBuscarResponse buscarPorNumeroEPotencia(@PathVariable("numero")Integer numero, @PathVariable("potencia")PotenciaEnum potencia) {

        return lojaBuscarService.buscarPorNumeroEPotencia(numero, potencia);

    }

    @GetMapping("/potencia/{potencia}")
    @Operation(summary = "Endpoint que retorna as lojas por potencia")
    public List<LojaBuscarResponse> buscarPorPotencia(@PathVariable("potencia") PotenciaEnum potencia) {

        return lojaBuscarService.buscarPorPotencia(potencia);

    }

    @PostMapping("/")
    @Operation(summary = "Endpoint que insere uma loja")
    public void inserir(@RequestBody LojaInserirRequest request) {

         lojaInserirService.inserir(request);

    }

}
