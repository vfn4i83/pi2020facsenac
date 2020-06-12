package back.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import back.senac.model.OrdemServico;

public interface ApiOrdemServico extends JpaRepository<OrdemServico, Long> {

}
