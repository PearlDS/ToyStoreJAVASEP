package toyPackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import toyPackage.data.Animal;
import toyPackage.services.interfaces.AnimalService;

@Controller
public class AnimalController {

    private AnimalService animalService;


    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("allAnimals")
    public String showAllanimals(Model model){
        model.addAttribute("animals", animalService.gatAllAnimals());
        return "animalPage";
    }

    @GetMapping("allAnimalsBS")
    public String showAllanimalsBS(Model model){
        model.addAttribute("animals", animalService.gatAllAnimals());
        return "index";
    }

    @GetMapping("animal/{id}")
    public String showSingleProduct(@PathVariable String id, Model model) {
        Integer idInInt;

        try {
            idInInt = Integer.parseInt(id);
        }catch (NumberFormatException e){
            System.out.println("Give a proper a number");
            idInInt =1;
        }

        Animal animal = animalService.getAnimalById(idInInt);
        model.addAttribute(animal);


        return "singleitem";
    }


    @GetMapping("addAnimal")
    public String makeAnimal(){
        return "animaladd";
    }

    @PostMapping("createAnimal")
    public String createAnimal(@ModelAttribute("animal")Animal animal){
        animalService.createAnimal(animal);
        return "redirect:allAnimalsBS";
    }
}
