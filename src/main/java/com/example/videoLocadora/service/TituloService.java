package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.TituloDTO;
import com.example.videoLocadora.entity.TituloEntity;
import com.example.videoLocadora.repository.AtorRepository;
import com.example.videoLocadora.repository.ClasseRepository;
import com.example.videoLocadora.repository.DiretorRepository;
import com.example.videoLocadora.repository.TituloRepository;
import com.example.videoLocadora.entity.AtorEntity;

@Service
public class TituloService {

    @Autowired
    private TituloRepository tituloRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    private AtorRepository atorRepository;

    // Listar todos
    public List<TituloDTO> listarTodos() {
        return tituloRepository.findAll()
                .stream()
                .map(TituloDTO::new)
                .toList();
    }

    // Inserir
    public void inserir(TituloDTO dto) {

        TituloEntity entity = new TituloEntity();

        entity.setNome(dto.getNome());
        entity.setAno(dto.getAno());
        entity.setSinopse(dto.getSinopse());
        entity.setCategoria(dto.getCategoria());

        // ------- CLASSE -------
        if (dto.getClasse() == null || dto.getClasse().getId() == null) {
            throw new RuntimeException("ID da classe é obrigatório!");
        }

        entity.setClasse(
                classeRepository.findById(dto.getClasse().getId())
                        .orElseThrow(() -> new RuntimeException("Classe não encontrada"))
        );

        // ------- DIRETOR -------
        if (dto.getDiretor() == null || dto.getDiretor().getId() == null) {
            throw new RuntimeException("ID do diretor é obrigatório!");
        }

        entity.setDiretor(
                diretorRepository.findById(dto.getDiretor().getId())
                        .orElseThrow(() -> new RuntimeException("Diretor não encontrado"))
        );

        // ------- ATORES -------
        if (dto.getAtores() == null || dto.getAtores().isEmpty()) {
            throw new RuntimeException("Pelo menos 1 ator é obrigatório!");
        }

        List<AtorEntity> atores = dto.getAtores()
                .stream()
                .map(a -> atorRepository.findById(a.getId())
                        .orElseThrow(() -> new RuntimeException("Ator não encontrado: ID = " + a.getId())))
                .toList();

        entity.setAtores(atores);

        tituloRepository.save(entity);
    }

    // Alterar
    public TituloDTO alterar(TituloDTO dto) {
        if (dto.getId() == null) {
            throw new RuntimeException("ID é obrigatório para alterar");
        }

        TituloEntity entity = tituloRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Título não encontrado"));

        entity.setNome(dto.getNome());
        entity.setAno(dto.getAno());
        entity.setSinopse(dto.getSinopse());
        entity.setCategoria(dto.getCategoria());

        // Atualiza classe
        entity.setClasse(
                classeRepository.findById(dto.getClasse().getId())
                        .orElseThrow(() -> new RuntimeException("Classe não encontrada"))
        );

        // Atualiza diretor
        entity.setDiretor(
                diretorRepository.findById(dto.getDiretor().getId())
                        .orElseThrow(() -> new RuntimeException("Diretor não encontrado"))
        );

        // Atualiza atores
        List<AtorEntity> atores = dto.getAtores()
                .stream()
                .map(a -> atorRepository.findById(a.getId())
                        .orElseThrow(() -> new RuntimeException("Ator não encontrado: ID = " + a.getId())))
                .toList();

        entity.setAtores(atores);

        tituloRepository.save(entity);

        return new TituloDTO(entity);
    }

    // Excluir
    public void excluir(Long id) {
        tituloRepository.deleteById(id);
    }

    // Buscar por id
    public TituloDTO buscarPorId(Long id) {
        return new TituloDTO(
                tituloRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Título não encontrado"))
        );
    }
}




