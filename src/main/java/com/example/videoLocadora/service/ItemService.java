package com.example.videoLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.videoLocadora.dto.ItemDTO;
import com.example.videoLocadora.entity.ItemEntity;
import com.example.videoLocadora.repository.ItemRepository;


import com.example.videoLocadora.repository.TituloRepository;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TituloRepository tituloRepository;

    // Listar todos
    public List<ItemDTO> listarTodos() {
        List<ItemEntity> itens = itemRepository.findAll();
        return itens.stream().map(ItemDTO::new).toList();
    }

    // Inserir
    public void inserir(ItemDTO dto) {

        ItemEntity item = new ItemEntity();

        item.setNumSerie(dto.getNumSerie());
        item.setDtAquisicao(dto.getDtAquisicao());
        item.setTipoItem(dto.getTipoItem());

        // Associa o título corretamente
        if (dto.getTitulo() != null && dto.getTitulo().getId() != null) {
            item.setTitulo(
                tituloRepository.findById(dto.getTitulo().getId()).orElse(null)
            );
        }

        itemRepository.save(item);
    }

    // Alterar
    public ItemDTO alterar(ItemDTO dto) {

        ItemEntity item = itemRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        item.setNumSerie(dto.getNumSerie());
        item.setDtAquisicao(dto.getDtAquisicao());
        item.setTipoItem(dto.getTipoItem());

        // Atualiza o título corretamente
        if (dto.getTitulo() != null && dto.getTitulo().getId() != null) {
            item.setTitulo(
                tituloRepository.findById(dto.getTitulo().getId()).orElse(null)
            );
        }

        return new ItemDTO(itemRepository.save(item));
    }

    // Excluir
    public void excluir(Long id) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        itemRepository.delete(item);
    }

    // Buscar por id
    public ItemDTO buscarPorId(Long id) {
        return new ItemDTO(
                itemRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Item não encontrado"))
        );
    }
}
