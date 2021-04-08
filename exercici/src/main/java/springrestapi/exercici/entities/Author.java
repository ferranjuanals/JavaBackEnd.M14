package springrestapi.exercici.entities;

import java.util.List;

import javax.persistence.*;

@Entity(name = "Author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 36, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Name", unique = true, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "author")
	private List<Collar> collars;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
