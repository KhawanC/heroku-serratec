package com.residencia.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.dto.CategoriaDTO;
import com.residencia.ecommerce.entity.Categoria;
import com.residencia.ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> findAllCategoria() {
		return categoriaRepository.findAll();
	}

	public Categoria findCategoriaById(Integer id) {
		return categoriaRepository.findById(id).isPresent() ? categoriaRepository.findById(id).get() : null;
	}

	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria updateCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public void deleteCategoriaById(Integer id) {
		categoriaRepository.deleteById(id);
	}
	
	private Categoria toEntity(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		
		categoria.setDescricaoCategoria(categoriaDTO.getDescricaoCategoria());
		categoria.setNomeCategoria(categoriaDTO.getNomeCategoria());
		
		return categoria;
	}
	
	private CategoriaDTO toDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		categoriaDTO.setIdCategoria(categoria.getIdCategoria());
		categoriaDTO.setDescricaoCategoria(categoria.getDescricaoCategoria());
		categoriaDTO.setNomeCategoria(categoria.getNomeCategoria());
		
		return categoriaDTO;
	}
} 
