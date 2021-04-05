package springrestapi.exercici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import springrestapi.exercici.dto.CollarRequestDto;
import springrestapi.exercici.dto.CollarResponseDto;
import springrestapi.exercici.entities.Shop;
import springrestapi.exercici.services.AuthorService;
import springrestapi.exercici.services.CollarService;
import springrestapi.exercici.services.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private CollarService collarService;
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addShop(@RequestBody Shop shop) {
		shopService.saveShop(shop);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Shop> getShops() {
		return shopService.getShops();
	}	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Shop getShopById(@PathVariable("id") Long shopId) {
		return shopService.getShopById(shopId);
	}
	
	@PostMapping(path = "/{id}/collars")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCollarToShop(@PathVariable("id") Long shopId, @RequestBody CollarRequestDto collarDto) {
		collarDto.setShop(shopService.getShopById(shopId));
		collarDto.setAuthor(authorService.checkAuthorByName(collarDto.getAuthor()));
		collarService.addCollar(collarDto);
	}
	
	@GetMapping(path = "/{id}/collars")  
	@ResponseStatus(HttpStatus.OK)
	public List<CollarResponseDto> getCollarsByShop(@PathVariable("id") Long id) {
		return collarService.getCollarsByShopId(id);
	}
	
	@DeleteMapping(path = "{id}/collars")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteAllCollarsByShop(@PathVariable("id") Long id) {
		collarService.deleteAllCollarsByShopId(id);
	}
}
