package br.com.fiap.dto;

import br.com.fiap.model.enums.Genero;

public class UsuarioDto {

    private long id;

    private String nomeUsuario;

    private String sobrenomeUsuario;

    private String email;

    private String senha;

    private long cpf;

    private Genero genero;

    public UsuarioDto() {
    }

    public UsuarioDto(long id, String nomeUsuario, String sobrenomeUsuario, String email, String senha, long cpf,
            Genero genero) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.sobrenomeUsuario = sobrenomeUsuario;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.genero = genero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobrenomeUsuario() {
        return sobrenomeUsuario;
    }

    public void setSobrenomeUsuario(String sobrenomeUsuario) {
        this.sobrenomeUsuario = sobrenomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "UsuarioDto [id=" + id + ", nomeUsuario=" + nomeUsuario + ", sobrenomeUsuario=" + sobrenomeUsuario
                + ", email=" + email + ", cpf=" + cpf + ", genero=" + genero + "]";
    }


    


    
}
