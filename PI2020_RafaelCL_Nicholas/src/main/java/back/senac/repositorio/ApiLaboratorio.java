package back.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import back.senac.model.Laboratorio;

public interface ApiLaboratorio extends JpaRepository<Laboratorio, Long> {

}
