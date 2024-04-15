package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.dto.UsuarioDto;
import br.com.fiap.mapper.UsuarioMapper;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;
import br.com.fiap.service.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	UsuarioMapper mapper;

	public UsuarioDto findById(Long id) {

		Optional<Usuario> usuarioEntity = repository.findById(id);
		usuarioEntity.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
		UsuarioDto dto = mapper.toDto(usuarioEntity.get());
		return dto;
	}

	public List<UsuarioDto> findAll() {
		List<UsuarioDto> dtos = mapper.toDtos(repository.findAll());

		return dtos;
	}

	public UsuarioDto insert(UsuarioDto usuarioDto) {
		Usuario entity = mapper.toEntity(usuarioDto);
		Usuario saveUsuario = repository.save(entity);
		return mapper.toDto(saveUsuario);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
