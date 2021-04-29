package springrestapi.exercici.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrestapi.exercici.dto.AuthorDto;
import springrestapi.exercici.entities.Author;
import springrestapi.exercici.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public List<AuthorDto> getAllAuthors() {
		return authorRepository.findAll().stream().map(author -> this.mapEntityToDto(author)).collect(Collectors.toList());
	}
	
	public Author checkAuthorName(Author author) {
		if(authorRepository.findByName(author.getName()).isPresent()) {
			return authorRepository.findByName(author.getName()).get();
		}else {
			return author;
		}
	}
	
	private AuthorDto mapEntityToDto(Author entity) {
		AuthorDto dto = new AuthorDto();
		dto.setName(entity.getName());
		return dto;
	}
}
