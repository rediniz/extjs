package br.com.renato.repository;

import java.util.List;
import br.com.renato.model.Usuario;

public interface UsuarioRepository {
	
	List<Usuario> listarUsuarios();
	
	Usuario inserirUsuario(Usuario usuario);
	
	Usuario apagarUsuario(Usuario usuario);
	
}
