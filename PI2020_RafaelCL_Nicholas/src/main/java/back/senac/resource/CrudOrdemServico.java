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

import back.senac.model.OrdemServico;
import back.senac.repositorio.ApiOrdemServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ordem_servico")
public class CrudOrdemServico {
		
	@Autowired
	private ApiOrdemServico apiOS;
	
	@GetMapping
	public List<OrdemServico> ordemServico(){
		return apiOS.findAll();
	}
	
	@PostMapping
	public ResponseEntity<OrdemServico> criar(@RequestBody OrdemServico ordSer,
			HttpServletResponse respostaServer){
		
		OrdemServico salvar = apiOS.save(ordSer);
		
		URI webUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(salvar.getId()).toUri(); 
		
		return ResponseEntity.created(webUrl).body(salvar);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long id, 
			@Valid @RequestBody OrdemServico ordemServico) {

		Optional<OrdemServico> ordemServBanco = apiOS.findById(id);
		BeanUtils.copyProperties(ordemServico, ordemServBanco.get(), "id");
		apiOS.save(ordemServBanco.get());

		return ResponseEntity.ok(ordemServico);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagar(@PathVariable Long id) {
		apiOS.deleteById(id);
	}
}
