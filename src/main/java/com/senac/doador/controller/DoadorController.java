package com.senac.doador.controller;

import com.senac.doador.dto.DoadorDTO;
import com.senac.doador.entity.Doador;
import com.senac.doador.service.DoadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/doador")
public class DoadorController {

    private final DoadorService doadorService;

    public DoadorController(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DoadorDTO>> listarTodos(){
        return ResponseEntity.ok(doadorService.listarTodos());
    }

    @PostMapping("/criar")
    public ResponseEntity<Doador> criar(@RequestBody Doador doador){
        return ResponseEntity.ok(doadorService.criarDoador(doador));
    }
}
