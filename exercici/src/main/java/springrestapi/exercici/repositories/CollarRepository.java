package springrestapi.exercici.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springrestapi.exercici.entities.Collar;

@Repository
public interface CollarRepository extends JpaRepository<Collar, Long> {

	public List<Collar> findAllByShopId(long id);
	
	public int countByShopId(long id);
	
	public void deleteByShopId(long id);
}
