package springrestapi.exercici.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springrestapi.exercici.dto.CollarRequestDto;
import springrestapi.exercici.dto.CollarResponseDto;
import springrestapi.exercici.entities.Collar;
import springrestapi.exercici.exception.DuplicateCollarException;
import springrestapi.exercici.repositories.CollarRepository;

@Service
public class CollarService {

	@Autowired
	CollarRepository collarRepository;
	
	public void addCollar(CollarRequestDto dto) {
		if(collarRepository.exists(Example.of(this.mapDtoToEntity(dto)))) throw new DuplicateCollarException(dto.getName(), dto.getAuthor().getName());
		collarRepository.save(this.mapDtoToEntity(dto));
	}
	
	public List<CollarResponseDto> getCollarsByShopId(Long id) {
		return collarRepository.findAllByShopId(id).stream().map(collar -> this.mapEntityToResponseDto(collar)).collect(Collectors.toList());
	}
	
	public List<CollarResponseDto> getCollars() {
		return collarRepository.findAll().stream().map(collar -> this.mapEntityToResponseDto(collar)).collect(Collectors.toList());
	}

	public Integer countCollarsByShop(Long shopId) {
		return collarRepository.countByShopId(shopId);
	}
	
	@Transactional
	public void deleteAllCollarsByShopId(Long id) {
		collarRepository.deleteByShopId(id);
	}
	
	private Collar mapDtoToEntity(CollarRequestDto dto) {
		Collar entity = new Collar();
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setEntryDate(LocalDate.now());
		entity.setShop(dto.getShop());
		entity.setAuthor(dto.getAuthor());	
		return entity;
	}
	
	private CollarResponseDto mapEntityToResponseDto(Collar entity) {
		CollarResponseDto dto = new CollarResponseDto();
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setShopName(entity.getShop().getName());
		if(entity.getAuthor() != null) {
			dto.setAuthorName(entity.getAuthor().getName());
		}else {
			dto.setAuthorName("Anonymous");
		}
		return dto;
	}
}
