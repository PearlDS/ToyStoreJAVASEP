package toyPackage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import toyPackage.data.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer> {
}
