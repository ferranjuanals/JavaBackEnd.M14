package springrestapi.exercici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import springrestapi.exercici.dto.CollarRequestDto;
import springrestapi.exercici.dto.CollarResponseDto;
import springrestapi.exercici.services.CollarService;

@RestController
@RequestMapping("/collars")
public class CollarController {

	@Autowired
	CollarService collarService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addCollar(@RequestBody CollarRequestDto collar) {
		collarService.addCollar(collar);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CollarResponseDto> getCollars() {
		return collarService.getCollars();
	}

}
