package br.com.fiap.controller;


import br.com.fiap.model.AuthenticationDTO;
import br.com.fiap.model.RegisterDTO;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.usuarioRepository.findByEmail(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String ecryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            Usuario usuario = new Usuario(data.login(), ecryptedPassword, data.role());
            this.usuarioRepository.save(usuario);
            return ResponseEntity.ok().build();
        }
    }
}