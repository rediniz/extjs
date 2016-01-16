package br.com.renato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.renato.model.Usuario;

import br.com.renato.repository.UsuarioRepository;

@Controller("usuarioController")
@RequestMapping(value="usuario/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="listar")
	public @ResponseBody List<Usuario> listar(){
		return usuarioRepository.listarUsuarios();
						
	}
	
	@ResponseBody
	@RequestMapping(value="adicionar")
	public Usuario adicionar(@RequestBody Usuario usuario){
		System.out.println("Dados recebidos no Spring:" + usuario.getNome() +", "+usuario.getEmail());
		return usuarioRepository.inserirUsuario(usuario);
				
	}
	
	@ResponseBody
	@RequestMapping(value="remover")
	public Usuario remover(@RequestBody Usuario usuario){
		
		return usuarioRepository.apagarUsuario(usuario);
				
	}

}
