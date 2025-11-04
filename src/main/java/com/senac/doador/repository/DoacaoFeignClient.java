package com.senac.doador.repository;

import com.senac.doador.dto.DoacaoDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name="doacao", url = "10.136.64.18:8080", path = "/api/doacao")
public interface DoacaoFeignClient {
    @GetMapping (value = "/listardoacaoporiddoador/{id}")
    public ResponseEntity<List<DoacaoDTO>> obterDoacaoPorDoadorId(@PathVariable("id") Integer id);
}
