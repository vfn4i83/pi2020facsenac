package back.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import back.senac.model.TipoServico;

public interface ApiTipoServico extends JpaRepository<TipoServico, Long> {

}
