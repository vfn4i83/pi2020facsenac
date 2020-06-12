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

import back.senac.model.Pessoa;
import back.senac.repositorio.ApiPessoa;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoa")
public class CrudPessoa {


	@Autowired
	private ApiPessoa apiPessoa;

	@GetMapping
	public List<Pessoa> pessoa() {
		return apiPessoa.findAll();
	}

	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa, HttpServletResponse respostaServer) {

		Pessoa salvar = apiPessoa.save(pessoa);

		URI webUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(salvar.getId()).toUri();

		return ResponseEntity.created(webUrl).body(salvar);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {

		Optional<Pessoa> pessoaBanco = apiPessoa.findById(id);
		BeanUtils.copyProperties(pessoa, pessoaBanco.get(), "id");
		apiPessoa.save(pessoaBanco.get());

		return ResponseEntity.ok(pessoa);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		apiPessoa.deleteById(id);
	}
}
