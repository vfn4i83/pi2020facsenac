package back.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import back.senac.model.Historico;

public interface ApiHistorico extends JpaRepository<Historico, Long> {

}
