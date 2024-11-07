package com.example.gerenciador_projeto.util;

import com.example.gerenciador_projeto.entities.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioUtils {

   public static Usuario criptografarSenha(Usuario usuario) {
      String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());
      usuario.setSenha(senhaCriptografada);
      return usuario;
   }

   public static boolean senhasBatem(String senha, String senhaEncoded) {
      return new BCryptPasswordEncoder().matches(senha, senhaEncoded);
   }

}
