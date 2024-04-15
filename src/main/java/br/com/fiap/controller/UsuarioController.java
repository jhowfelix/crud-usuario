package br.com.fiap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.dto.UsuarioDto;
import br.com.fiap.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@PostMapping()
	public ResponseEntity<UsuarioDto> insert(@RequestBody @Valid UsuarioDto usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(usuario));
	}

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
		UsuarioDto byId = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(byId);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> update(@RequestBody @Valid UsuarioDto newUsuario,@PathVariable Long id) {
		UsuarioDto usuario = service.findById(id);
		BeanUtils.copyProperties(newUsuario, usuario);
		usuario.setId(id);
		service.insert(usuario);
		return ResponseEntity.ok(usuario);

	}

}
