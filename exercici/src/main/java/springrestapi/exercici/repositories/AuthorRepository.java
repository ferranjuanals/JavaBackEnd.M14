package springrestapi.exercici.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springrestapi.exercici.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	public Author findByName(String name);
}
