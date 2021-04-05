package springrestapi.exercici.entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Shops")
public class Shop {

	@Id
	@SequenceGenerator(name = "shopSequence", sequenceName = "shopSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopSequence")
	@Column(name = "Id", length = 36, updatable = false, nullable = false)
	private long id;
	
	@Column(name = "Name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "Capacity", nullable = false)
	private Integer capacity;
	
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	private List<Collar> collars;

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}	
}
