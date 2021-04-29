package springrestapi.exercici.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import springrestapi.exercici.dto.CollarRequestDto;
import springrestapi.exercici.dto.CollarResponseDto;
import springrestapi.exercici.dto.ShopDto;
import springrestapi.exercici.entities.Shop;
import springrestapi.exercici.exception.IdNotFoundException;
import springrestapi.exercici.exception.NameNotValidException;
import springrestapi.exercici.exception.ShopMaxCapacityException;
import springrestapi.exercici.repositories.ShopRepository;

@Service
public class ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private CollarService collarService;
	
	@Autowired 
	private AuthorService authorService;
	
	public ShopDto addShop(ShopDto dto) {
		if(!StringUtils.hasText(dto.getName())) throw new NameNotValidException(dto.getName());
		if(shopRepository.findByName(dto.getName()).isPresent()) throw new NameNotValidException(dto.getName());
		Shop shop = this.mapDtoToEntity(dto);
		shopRepository.save(shop);
		return this.mapEntityToDto(shop);
	}

	public List<ShopDto> getShops() {
		return shopRepository.findAll().stream().map(shop -> this.mapEntityToDto(shop)).collect(Collectors.toList());
	}
	
	public ShopDto getShop(Long id) {
		return this.mapEntityToDto(this.getShopById(id));
	}
	
	public void addCollarToShop(Long id, CollarRequestDto requestDto) {
		Shop shop = this.getShopById(id);
		if(collarService.countCollarsByShop(id) >= shop.getCapacity()) throw new ShopMaxCapacityException(shop.getName(), shop.getCapacity());
		requestDto.setShop(shop);
		requestDto.setAuthor(authorService.checkAuthorName(requestDto.getAuthor()));
		collarService.addCollar(requestDto);
	}

	public List<CollarResponseDto> getCollarsByShopId(Long shopId) {
		return collarService.getCollarsByShopId(shopId);	
	}

	public void deleteAllCollarsByShopId(Long shopId) {
		collarService.deleteAllCollarsByShopId(shopId);		
	}
	
	private Shop getShopById(Long id) {
		return shopRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
	}

	private Integer getCollarsCount(Long id) {
		return collarService.countCollarsByShop(id);
	}

	private Shop mapDtoToEntity(ShopDto shopDto) {
		Shop shop = new Shop();
		shop.setName(shopDto.getName());
		shop.setCapacity(shopDto.getCapacity());
		return shop;
	}
	
	private ShopDto mapEntityToDto(Shop shop) {
		ShopDto shopDto = new ShopDto();
		shopDto.setId(shop.getId());
		shopDto.setName(shop.getName());
		shopDto.setCapacity(shop.getCapacity());
		shopDto.setCount(this.getCollarsCount(shop.getId()));
		return shopDto;
	}
	
}
