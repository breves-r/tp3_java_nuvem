package br.edu.infnet.tp3Nuvem.model.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.tp3Nuvem.model.domain.Usuario;
import br.edu.infnet.tp3Nuvem.model.repository.UsuarioRepository;



@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    private List<Usuario> usuarios = new ArrayList();
    
    public List<Usuario> consultarUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();
    }
    
    public Usuario consultarUsuario(int id){
        return usuarioRepository.findById(id).get();
    }
    
    public void incluirUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    public String alterarUsuario(Usuario novoUsuario, int id){
        String msg = "Usuário alterado";
        
        
        usuarioRepository.findById(id).map(usuario -> {
        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());
        usuario.setTelefone(novoUsuario.getTelefone());
        usuario.setCep(novoUsuario.getCep());
        usuario.setEndereco(novoUsuario.getEndereco());
        return usuarioRepository.save(usuario);
        }).orElseGet(() -> {
        novoUsuario.setId(id);
        return usuarioRepository.save(novoUsuario);
        });
        
        return msg;
        
    }
    
    public String excluirUsuario(int id){
        String msg = "Erro ao excluir usuário";
        
        Usuario usuario = usuarioRepository.findById(id).get();
        
            if(usuario!=null){
                usuarioRepository.delete(usuario);
                msg = "Usuário excluído";
            }
        return msg;
    }
    
    public List<Usuario> procurarUsuarios(String keyword){
        List<Usuario> lista = usuarioRepository.busca(keyword);
        
        return lista;
    }
    
}
