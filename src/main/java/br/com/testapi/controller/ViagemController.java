package br.com.testapi.controller;

import java.util.List;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.testapi.data.ViagemDto;
import br.com.testapi.entities.Viagem;
import br.com.testapi.responses.Response;
import br.com.testapi.services.ViagemServices;

@RestController
@RequestMapping("/api/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemServices viagemService;

	@PostMapping(path = "/new")
	public ResponseEntity<Response<Viagem>> cadastrar(@Valid @RequestBody ViagemDto viagemDto, BindingResult result) {
		
		Response<Viagem> response = new Response<Viagem>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Viagem viagemSalva = this.viagemService.salvar(viagemDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagemDto.getId())
				.toUri();

		response.setData(viagemSalva);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping
	public ResponseEntity<List<Viagem>> listar() {
		List<Viagem> viagens = viagemService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(viagens);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Viagem>> buscar(@PathVariable("id") Long id) {
  
		Viagem viagem = viagemService.buscar(id);
		Response<Viagem> response = new Response<Viagem>();
		response.setData(viagem);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
