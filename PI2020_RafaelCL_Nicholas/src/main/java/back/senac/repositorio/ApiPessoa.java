package back.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import back.senac.model.Pessoa;

public interface ApiPessoa extends JpaRepository<Pessoa, Long> {

}
