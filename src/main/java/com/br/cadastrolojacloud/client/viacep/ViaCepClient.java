package com.br.cadastrolojacloud.client.viacep;

import com.br.cadastrolojacloud.client.viacep.response.AddressResponse;
import feign.Logger;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "viaCep", url = "${viacep.endpoint}",  configuration = ViaCepClient.Configuration.class)
public interface ViaCepClient {

    @GetMapping(value = "/{cep}/json")
    AddressResponse getAddress(@PathVariable(value = "cep") String cep);

    class Configuration {

        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }

        @Bean
        public Logger.Level feignLoggerLevel() {
            return Logger.Level.BASIC;
        }
    }
}