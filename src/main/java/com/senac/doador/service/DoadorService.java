package com.senac.doador.service;

import com.senac.doador.dto.DoadorDTO;
import com.senac.doador.dto.DoacaoDTO;
import com.senac.doador.entity.Doador;
import com.senac.doador.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DoadorService {

    private final DoadorRepository doadorRepository;
    private final RestTemplate restTemplate;

    @Value("${servico.doacao.url}")
    private String servicoDoacaoUrl;

    public DoadorService(DoadorRepository doadorRepository, RestTemplate restTemplate) {
        this.doadorRepository = doadorRepository;
        this.restTemplate = restTemplate;
    }

    public Doador criarDoador(Doador doador) {
        // Remove o ID se vier no JSON (para evitar conflito)
        doador.setId(null);
        return doadorRepository.save(doador);
    }

    public List<DoadorDTO> listarTodos() {
        List<Doador> doadores = doadorRepository.findAll();
        List<DoadorDTO> doadoresDTO = new ArrayList<>();

        for (Doador doador : doadores) {
            DoadorDTO dto = new DoadorDTO();
            dto.setId(doador.getId());
            dto.setNome(doador.getNome());
            dto.setEndereco(doador.getEndereco());
            dto.setStatus(doador.getStatus());

            // Buscar doações do doador no serviço do Aluno B
            try {
                String url = servicoDoacaoUrl + "/api/doacoes/obterdoacoesdousuario/" + doador.getId();
                DoacaoDTO[] doacoes = restTemplate.getForObject(url, DoacaoDTO[].class);

                if (doacoes != null) {
                    dto.setDoacoes(Arrays.asList(doacoes));
                } else {
                    dto.setDoacoes(new ArrayList<>());
                }
            } catch (Exception e) {
                System.out.println("Erro ao buscar doações do doador " + doador.getId() + ": " + e.getMessage());
                dto.setDoacoes(new ArrayList<>());
            }

            doadoresDTO.add(dto);
        }

        return doadoresDTO;
    }
}