package prog.Presenter;

import prog.Model.Animals;

import java.util.ArrayList;
import java.util.List;

public class AnimalsRegistry {
    private List<Animals> animalsList = new ArrayList<>();
    private int counter;
    public void addAnimal(Animals animal){
        animalsList.add(animal);
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void printAnimalRegistry(){
        for(Animals animal: animalsList){
            animal.printAnimalInfo();
        }
    }
}
