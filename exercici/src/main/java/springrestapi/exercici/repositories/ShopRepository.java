package springrestapi.exercici.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springrestapi.exercici.entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

	Optional<Shop> findByName(String name);

}
