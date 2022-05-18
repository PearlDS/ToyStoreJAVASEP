package toyPackage.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toyPackage.data.Animal;
import toyPackage.repositories.AnimalRepository;
import toyPackage.services.interfaces.AnimalService;

import java.util.List;

@Service
public class AnimalServiceImplementation implements AnimalService {


    private AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImplementation(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> gatAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(int id) {
        Animal animal = animalRepository.findById(id).get();
        return animal ;
    }

    @Override
    public void createAnimal(Animal animal) {
        animalRepository.save(animal);

    }
}
