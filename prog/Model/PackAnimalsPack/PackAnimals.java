package prog.Model.PackAnimalsPack;

import prog.Model.Animals;
import prog.Model.Commands;

import java.time.LocalDate;

public abstract class PackAnimals extends Animals {
    private final String superType = "Pack Animals";


    public PackAnimals(String name, LocalDate dateOfBirth, Commands commands) {
        super(name, dateOfBirth, commands);
    }
}
