package prog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Settings {
    private final String dateFormat = "yyyy-MM-dd";
    private final Map<Integer, String> animals = new HashMap<>();
    private final String[] animalsArr = {"cat", "dog", "hamster", "horse", "donkey", "camel"};

    {
        for (int i = 0; i < animalsArr.length; i++) {
            animals.put(i + 1, animalsArr[i]);
        }
    }

    private final String menuText = "Input menu type 'a' - add animal, 'q' - quit";


    public String getDateFormat() {
        return dateFormat;
    }

    public Map<Integer, String> getAnimals() {
        return animals;
    }

    public String getMenuText() {
        return menuText;
    }

    public String getAnimalsList(){
        return animals.toString();
    }
}
