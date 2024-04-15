package br.com.fiap.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.fiap.dto.UsuarioDto;
import br.com.fiap.model.Usuario;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDto toDto(Usuario usuario);
    
    Usuario toEntity(UsuarioDto dto);

    List<UsuarioDto> toDtos(List<Usuario> usuarios);

}
