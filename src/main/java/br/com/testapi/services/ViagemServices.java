package br.com.testapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testapi.data.ViagemDto;
import br.com.testapi.entities.Viagem;
import br.com.testapi.repositories.ViagemRepository;
import br.com.testapi.services.exceptions.ViagemServiceException;

@Service
public class ViagemServices {
	
	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}

	public Viagem salvar(ViagemDto viagemDto) {

		Viagem viagem = new Viagem();

		viagem.setLocalDeDestino(viagemDto.getLocalDeDestino());
		viagem.setDataPartida(viagemDto.getDataPartida());
		viagem.setDataRetorno(viagemDto.getDataRetorno());
		viagem.setAcompanhante(viagemDto.getAcompanhante());
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) {
		Optional<Viagem> viagem = viagemRepository.findById(id);

		if (viagem == null) {
	//		throw new ViagemServiceException("Não existe esta viagem cadastrada");
		}
		return viagem.get();
	}

}
