package com.senac.doador.service;

import com.senac.doador.dto.DoadorDTO;
import com.senac.doador.entity.Doador;
import com.senac.doador.repository.DoacaoFeignClient;
import com.senac.doador.repository.DoadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoadorService {
    private final DoadorRepository doadorRepository;
    private final DoacaoFeignClient doacaoFeignClient;

    public DoadorService(DoadorRepository doadorRepository, DoacaoFeignClient doacaoFeignClient) {
        this.doadorRepository = doadorRepository;
        this.doacaoFeignClient = doacaoFeignClient;
    }

    public List<DoadorDTO> listarTodos() {
        List<Doador> doadoresTotal = doadorRepository.findAll();
        List<DoadorDTO> doadores = new ArrayList<DoadorDTO>();
        for (int i=0; i< doadoresTotal.size(); i++){
            DoadorDTO doadorDTO = new DoadorDTO();
            doadorDTO.setId(doadoresTotal.get(i).getId());
            doadorDTO.setNome(doadoresTotal.get(i).getNome());
            doadorDTO.setEndereco(doadoresTotal.get(i).getEndereco());
            doadorDTO.setStatus(doadoresTotal.get(i).getStatus());
            doadorDTO.setDoacoes(doacaoFeignClient.obterDoacaoPorDoadorId(doadoresTotal.get(i).getId()).getBody());
            doadores.add(doadorDTO);
        }
        return doadores;
    }
    public Doador criarDoador(Doador doador){
        Doador doadorNovo = doadorRepository.save(doador);
        return doadorNovo;
    }
}
