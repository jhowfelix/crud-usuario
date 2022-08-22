package br.com.fiap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	
	public Usuario findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public void insert(Usuario usuario) {
		repository.save(usuario);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
