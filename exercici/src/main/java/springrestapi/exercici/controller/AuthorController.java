package springrestapi.exercici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import springrestapi.exercici.entities.Author;
import springrestapi.exercici.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Author> getAuthors() {
		return authorService.findAllAuthors();
	}
	
	@GetMapping("/{name}")
	@ResponseStatus(HttpStatus.OK)
	public Author getAuthorsByName(@PathVariable("name") String name) {
		return authorService.findAuthorsByName(name);
	}
}
