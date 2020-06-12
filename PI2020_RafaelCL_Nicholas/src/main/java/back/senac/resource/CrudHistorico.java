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

import back.senac.model.Historico;
import back.senac.repositorio.ApiHistorico;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/historico")
public class CrudHistorico {


	@Autowired
	private ApiHistorico apiHistorico;

	@GetMapping
	public List<Historico> historico() {
		return apiHistorico.findAll();
	}

	@PostMapping
	public ResponseEntity<Historico> criar(@RequestBody Historico historico, 
			HttpServletResponse respostaServer) {

		Historico salvar = apiHistorico.save(historico);

		URI webUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(salvar.getId()).toUri();

		return ResponseEntity.created(webUrl).body(salvar);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Historico> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Historico historico) {

		Optional<Historico> historicoBanco = apiHistorico.findById(id);
		BeanUtils.copyProperties(historico, historicoBanco.get(), "id");
		apiHistorico.save(historicoBanco.get());

		return ResponseEntity.ok(historico);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		apiHistorico.deleteById(id);
	}
}
