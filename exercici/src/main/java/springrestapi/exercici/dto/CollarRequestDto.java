package springrestapi.exercici.dto;

import springrestapi.exercici.entities.Author;
import springrestapi.exercici.entities.Shop;

public class CollarRequestDto {

	private String name;
	private Double price;
	private Shop shop;
	private Author author;
	
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
}
