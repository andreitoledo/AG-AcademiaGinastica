/**
 * @author andrei
 *
 * 5 de dez de 2018
 */
package com.andreitoledo.ac.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.andreitoledo.ac.model.Usuario;

/**
 * @author andrei
 *
 */

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;

	/*
	 * essa classe vai representar um usuario, quando fizer login vai armazenar
	 * na memória o usuario_sistema que é um objeto dessa classe o spring faz
	 * isso ! *
	 */

	private Usuario usuario;

	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
