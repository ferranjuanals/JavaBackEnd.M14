package springrestapi.exercici.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "Collars")
public class Collar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 36, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "Name", nullable = false)
	private String name;
	
	@Column(name = "Price", nullable = false)
	private Double price;
	
	@Column(name = "Entry_Date", nullable = false)
	private LocalDate entryDate;
	
	@JoinColumn(name = "Shop", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Shop shop;
	
	@JoinColumn(name = "Author")
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Author author;
	
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Collar [name=" + name + ", price=" + price + ", shop=" + shop + ", author="
				+ author + "]";
	}
	
	
}
