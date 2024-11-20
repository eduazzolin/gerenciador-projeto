package com.example.gerenciador_projeto.service;

import com.example.gerenciador_projeto.entities.Usuario;
import com.example.gerenciador_projeto.repository.UsuarioRepository;
import com.example.gerenciador_projeto.util.UsuarioUtils;
import com.example.gerenciador_projeto.util.Validacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UsuarioService {

   @Autowired
   private UsuarioRepository repository;
   @Autowired
   private Validacoes validacoes;

   public Optional<Usuario> obterPorId(Long id) {
      return repository.findById(id);
   }

   public Usuario salvar(Usuario usuario) {
      usuario.setDataCriacao(LocalDateTime.now());

      if (!validacoes.validarUsuario(usuario)) {
         throw new RuntimeException("Erro ao criar usuário");
      }

      if (usuario.getId() == null) {
         repository.findByEmail(usuario.getEmail()).ifPresent(u -> {
            throw new RuntimeException("Email já cadastrado");
         });
      }

      UsuarioUtils.criptografarSenha(usuario);
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
