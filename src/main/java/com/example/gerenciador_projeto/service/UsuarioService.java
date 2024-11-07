package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.UsuarioRepository;
import com.example.gerenciador_projeto.util.UsuarioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UsuarioService  {

   @Autowired
   private UsuarioRepository repository;


   public Optional<Usuario> obterPorId(Long id) {
      return repository.findById(id);
   }

   public Usuario salvar(Usuario usuario) {
//      UsuarioUtils.validarEmail(usuario.getEmail()); #todo
      UsuarioUtils.criptografarSenha(usuario);
      usuario.setDataCriacao(LocalDateTime.now());
      return repository.save(usuario);
   }

   public Usuario autenticar(String email, String senha) throws Exception {
      Optional<Usuario> usuario = repository.findByEmail(email);

      if (usuario.isEmpty()) {
         throw new Exception("Usuário não encontrado.");
      }

      boolean senhasBatem = UsuarioUtils.senhasBatem(senha, usuario.get().getSenha());


      if (!senhasBatem) {
         throw new Exception("Senha inválida.");
      }

      return usuario.get();
   }


}
