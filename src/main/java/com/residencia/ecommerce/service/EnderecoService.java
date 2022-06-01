package com.residencia.ecommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.dto.ConsultaCepDTO;
import com.residencia.ecommerce.dto.EnderecoDTO;
import com.residencia.ecommerce.entity.Endereco;
import com.residencia.ecommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository enderecoRepository;

	public List<Endereco> findAllEndereco() {
		return enderecoRepository.findAll();
	}

	public Endereco findByIdEndereco(Integer idEndereco) {
		return enderecoRepository.findById(idEndereco).isPresent() ? enderecoRepository.findById(idEndereco).get()
				: null;
	}

	public Endereco saveEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco updateEndereco(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public void deleteByIdEndereco(Integer idEndereco) {
		enderecoRepository.deleteById(idEndereco);
	}
	
	//api externa
	public ConsultaCepDTO consultarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://viacep.com.br/ws/{cep}/json/";

        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);

        ConsultaCepDTO cadastroCepDTO = restTemplate.getForObject(uri,ConsultaCepDTO.class, params);

        return cadastroCepDTO;
    }
	
	//DTO
	public Endereco saveEnderecoDTO(String cep, Integer numero) {
		String cepFormatado = cep.replaceAll("[.-]", "");
		ConsultaCepDTO cepDTO = consultarCep(cepFormatado);
		Endereco endereco = cepDTOtoEndereco(cepDTO);
		endereco.setNumero(numero);
		
		return enderecoRepository.save(endereco);
	}
	
	//conversão
	private Endereco toEntity(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();

		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getRua());

		return endereco;
	}

	private EnderecoDTO toDTO(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();

		enderecoDTO.setIdEndereco(endereco.getIdEndereco());
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setComplemento(endereco.getComplemento());
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setRua(endereco.getRua());

		return enderecoDTO;
	}
	
	private Endereco cepDTOtoEndereco(ConsultaCepDTO cepDTO) {
		Endereco endereco = new Endereco();
		endereco.setBairro(cepDTO.getBairro());
		endereco.setCep(cepDTO.getCep());
		endereco.setCidade(cepDTO.getLocalidade());
		endereco.setComplemento(cepDTO.getComplemento());
		endereco.setRua(cepDTO.getLogradouro());
		endereco.setUf(cepDTO.getUf());
		
		return endereco;
	}

}
