package br.edu.infnet.tp3Nuvem;

import br.edu.infnet.tp3Nuvem.cliente.IClienteAPI;
import br.edu.infnet.tp3Nuvem.model.domain.Endereco;
import br.edu.infnet.tp3Nuvem.model.domain.Usuario;
import br.edu.infnet.tp3Nuvem.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Principal implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        incluir();
        listar();
        consultarUsuario();
        excluir();
        listar();
        
    }
    
    @Autowired
    private IClienteAPI clienteAPI;
    
    @Autowired
    private UsuarioService usuarioService;
        
    public void incluir(){
        Usuario usuario = new Usuario();
        usuario.setNome("Rafaela");
        usuario.setEmail("rafaela@email");
        usuario.setTelefone("219999999");
        usuario.setCep("20020040");
        
        Endereco endereco = clienteAPI.buscaEnderecoPor(usuario.getCep());
        usuario.setEndereco(endereco);
        
        usuarioService.incluirUsuario(usuario);
        
        Usuario usuario2 = new Usuario();
        usuario2.setNome("LP");
        usuario2.setEmail("lp@email");
        usuario2.setTelefone("21888888");
        usuario2.setCep("20020030");
        
        Endereco endereco2 = clienteAPI.buscaEnderecoPor(usuario2.getCep());
        usuario2.setEndereco(endereco2);
        
        usuarioService.incluirUsuario(usuario2);
            
        }
    
    public void listar(){
        System.out.println(usuarioService.consultarUsuarios());
    }
    
    public void consultarUsuario(){
       System.out.println(usuarioService.consultarUsuario(1));
    }
    
    public void excluir(){
        usuarioService.excluirUsuario(1);
    }
    
}
