package springrestapi.exercici.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springrestapi.exercici.entities.Shop;
import springrestapi.exercici.exception.IdNotFoundException;
import springrestapi.exercici.repositories.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	public Shop saveShop(Shop shop) {
		shopRepository.save(shop);
		return shop;
	}
	
	public List<Shop> getShops() {
		return shopRepository.findAll();
	}
	
	public Shop getShopById(Long id) {
		return shopRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
	}
}
