package toyPackage.services.interfaces;

import toyPackage.data.Animal;

import java.util.List;

public interface AnimalService {

    public List<Animal> gatAllAnimals();
    public Animal getAnimalById(int id);
    public void createAnimal(Animal animal);

}
