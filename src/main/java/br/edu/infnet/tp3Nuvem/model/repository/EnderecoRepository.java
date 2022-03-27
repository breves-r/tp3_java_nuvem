package br.edu.infnet.tp3Nuvem.model.repository;

import br.edu.infnet.tp3Nuvem.model.domain.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository <Endereco, Integer> {
    
}
