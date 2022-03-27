package br.edu.infnet.tp3Nuvem.model.repository;


import br.edu.infnet.tp3Nuvem.model.domain.Usuario;
import feign.Param;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
    @Query("SELECT c FROM Usuario c WHERE c.nome LIKE '%' || :keyword || '%' OR c.telefone LIKE '%' || :keyword || '%'")
    public List<Usuario> busca(@Param("keyword") String keyword);
}
