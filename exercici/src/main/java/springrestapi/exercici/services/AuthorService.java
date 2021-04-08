package springrestapi.exercici.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrestapi.exercici.entities.Author;
import springrestapi.exercici.exception.IdNotFoundException;
import springrestapi.exercici.repositories.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}
	
	public Author getAuthorById(Long id) {
		Author author = authorRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
		return author;
	}
	
	public Author findAuthorsByName(String name) {
		return authorRepository.findByName(name);
	}
	
	public Author getAuthorByName(String name) {
		if(authorRepository.findByName(name) != null) {
			return authorRepository.findByName(name);
		}else {
			Author newAuthor = new Author();
			newAuthor.setName(name);
			authorRepository.save(newAuthor);
			return newAuthor;
//			return authorRepository.findByName(name).get();
		}
	}
	
	public Author checkAuthorByName(Author author) {
		if(authorRepository.findByName(author.getName()) != null) {
			return authorRepository.findByName(author.getName());
		}else {
			return author;
		}
	}
}
