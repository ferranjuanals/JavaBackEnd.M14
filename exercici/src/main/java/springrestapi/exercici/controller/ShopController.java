package springrestapi.exercici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import springrestapi.exercici.dto.CollarRequestDto;
import springrestapi.exercici.dto.CollarResponseDto;
import springrestapi.exercici.dto.ShopDto;
import springrestapi.exercici.services.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ShopDto addShop(@RequestBody ShopDto shopDto) {
		return shopService.addShop(shopDto);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ShopDto> getShops() {
		return shopService.getShops();
	}	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ShopDto getShop(@PathVariable("id") Long shopId) {
		return shopService.getShop(shopId);
	}
	
	@PostMapping(path = "/{id}/collars")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCollarToShop(@PathVariable("id") Long shopId, @RequestBody CollarRequestDto requestDto) {
		shopService.addCollarToShop(shopId, requestDto);
	}
	
	@GetMapping(path = "/{id}/collars")  
	@ResponseStatus(HttpStatus.OK)
	public List<CollarResponseDto> getCollarsByShop(@PathVariable("id") Long shopId) {
		return shopService.getCollarsByShopId(shopId);
	}
	
	@DeleteMapping(path = "{id}/collars")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteAllCollarsByShop(@PathVariable("id") Long shopId) {
		shopService.deleteAllCollarsByShopId(shopId);
	}
}
