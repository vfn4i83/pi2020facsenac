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

import back.senac.model.TipoServico;
import back.senac.repositorio.ApiTipoServico;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tiposervico")
public class CrudTipoServico {


	@Autowired
	private ApiTipoServico apiTipoServico;

	@GetMapping
	public List<TipoServico> tipoServico() {
		return apiTipoServico.findAll();
	}

	@PostMapping
	public ResponseEntity<TipoServico> criar(@RequestBody TipoServico tipoServico, 
			HttpServletResponse respostaServer) {

		TipoServico salvar = apiTipoServico.save(tipoServico);

		URI webUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(salvar.getId()).toUri();

		return ResponseEntity.created(webUrl).body(salvar);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoServico> atualizar(@PathVariable Long id, 
			@Valid @RequestBody TipoServico tipoServico) {

		Optional<TipoServico> tpsBanco = apiTipoServico.findById(id);
		BeanUtils.copyProperties(tipoServico, tpsBanco.get(), "id");
		apiTipoServico.save(tpsBanco.get());

		return ResponseEntity.ok(tipoServico);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		apiTipoServico.deleteById(id);
	}
}
