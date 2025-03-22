package com.example.festora.model.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.example.festora.model.Requisito;
import com.example.festora.model.Usuario;

import lombok.Data;

@Data
public class RequisitoResponseDTO {

	private String id;
	
	private String titulo;
	
	private String descricao;
	
	private List<UsuarioResponseDTO> responsaveis;
	
	public RequisitoResponseDTO(Requisito requisito) {
		this.id = requisito.getId();
		this.titulo = requisito.getTitulo();
		this.descricao = requisito.getDescricao();
		this.responsaveis = converterUsuarioDTOs(requisito.getResponsaveis());
	}
	
	private List<UsuarioResponseDTO> converterUsuarioDTOs(List<Usuario> responsaveis) {
		return responsaveis.stream()
				.map(r -> new UsuarioResponseDTO(r))
				.collect(Collectors.toList());
	}
}



