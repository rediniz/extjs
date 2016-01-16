package br.com.renato.repository;

import java.util.ArrayList;
//1903000762
import java.util.List;
import org.springframework.stereotype.Repository;
import br.com.renato.model.Usuario;

@Repository("usuarioRepository")
public class UsuarioRepositoryImpl implements UsuarioRepository {

	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	String nomes[] = { "Fulano", "Sicrano", "Beltrano" };

	public UsuarioRepositoryImpl(){
		carregarUsuarios();
	}
	public List<Usuario> listarUsuarios() {

		return listaUsuarios;
	}

	private void carregarUsuarios() {
		for (int i = 0; i < nomes.length; i++) {
			Usuario u = new Usuario();
			u.setId((long) i + 1);
			u.setNome(nomes[i]);
			u.setEmail(nomes[i].toLowerCase() + "@gmail.com");
			listaUsuarios.add(u);
		}
	}

	public Usuario inserirUsuario(Usuario usuario) {
		usuario.setId(((long) listaUsuarios.size() + 1));
		listaUsuarios.add(usuario);
		System.out.println("Usuário cadastrado > id = " + usuario.getId() + ", nome = " + usuario.getNome()
				+ ", email = " + usuario.getEmail());
		return usuario;
	}
	public Usuario apagarUsuario(Usuario usuario) {
		for (int i = 0; i < listaUsuarios.size(); i++) {
			if (usuario.getId() == listaUsuarios.get(i).getId()) {
				listaUsuarios.remove(i);
			}
		}	
		return usuario;
	}

}
