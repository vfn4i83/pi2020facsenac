package back.senac.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import back.senac.model.Laboratorio;
import back.senac.repositorio.ApiLaboratorio;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/laboratorio")
public class CrudLaboratorio {


	@Autowired
	private ApiLaboratorio apiLaboratorio;

	@GetMapping
	public List<Laboratorio> laboratorio() {
		return apiLaboratorio.findAll();
	}

	@PostMapping
	public ResponseEntity<Laboratorio> criar(@RequestBody Laboratorio laboratorio, 
			HttpServletResponse respostaServer) {

		Laboratorio salvar = apiLaboratorio.save(laboratorio);

		URI webUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(salvar.getId()).toUri();

		return ResponseEntity.created(webUrl).body(salvar);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Laboratorio> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Laboratorio laboratorio) {

		Optional<Laboratorio> laboratorioBanco = apiLaboratorio.findById(id);
		BeanUtils.copyProperties(laboratorio, laboratorioBanco.get(), "id");
		apiLaboratorio.save(laboratorioBanco.get());

		return ResponseEntity.ok(laboratorio);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		apiLaboratorio.deleteById(id);
	}
}
