package prog;

import prog.Model.Animals;
import prog.Model.Commands;
import prog.Model.PackAnimalsPack.Camel;
import prog.Model.PetsPack.Cat;
import prog.Presenter.AnimalsRegistry;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
    public void run() {
        Settings settings = new Settings();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
        //String name = scanner.nextLine();
//        String strDate  = scanner.nextLine();
        //String commands = scanner.nextLine();
        LocalDate date = LocalDate.now(); // temporary date NOW!
//        try {
//            date = LocalDate.parse(strDate, formatter);
//        } catch (DateTimeException e) {
//            System.out.println("Incorrect date format, please input date format as " + settings.getDateFormat());
//        }
        Commands commands = new Commands();
        AnimalsRegistry animalsRegistry = new AnimalsRegistry();
        commands.addCommand("Meow");
//        cat1.printAnimalInfo();
        Cat cat1 = new Cat("dusya", date, commands);
        System.out.println(cat1.getName() + " " + cat1.getDateOfBirth() + " " + cat1.getSuperType() + " " + cat1.getType() + " " + cat1.getCommands());
        cat1.printCommands();
        commands.addCommand("Bow");
        System.out.println(cat1.getName() + " " + cat1.getDateOfBirth() + " " + cat1.getSuperType() + " " + cat1.getType() + " " + cat1.getCommands());
        cat1.printCommands();
        animalsRegistry.addAnimal(cat1);
        animalsRegistry.addAnimal(cat1);
        Camel camel1 = new Camel("egor", date, commands);
        animalsRegistry.addAnimal(camel1);
        camel1.printAnimalInfo();
        System.out.println("Count animal: " + animalsRegistry.getCounter());

        System.out.println(settings.getMenuText());
        String inputCommand = scanner.nextLine();
        while (!inputCommand.equals("q")){
            switch (inputCommand){
                case "a":
                    System.out.println("a");
                        animalsRegistry.addAnimal(addAnimal());
                    break;
                case "p":
                    System.out.println("l");
                    animalsRegistry.printAnimalRegistry();
                    break;
            }
            System.out.println(settings.getMenuText());
            inputCommand = scanner.nextLine();
        }
    }


    public Animals addAnimal(){
        Settings settings= new Settings();
        Scanner scanner = new Scanner(System.in);
        Animals animal = null;
        System.out.println("Please choose the type of animal " + settings.getAnimalsList());
        int menu1 = scanner.nextInt();
        scanner.nextLine();
        if (settings.getAnimals().containsKey(menu1))
        {
            System.out.println("Well! You choose " +  settings.getAnimals().get(menu1));
            System.out.println("Input name: ");
            String name = scanner.nextLine();
            System.out.println("Input date of birth (format: yyyy-MM-dd): ");
            String dateOfBirthStr = scanner.nextLine();
            LocalDate dateOfBirth = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
            try {
                dateOfBirth = LocalDate.parse(dateOfBirthStr, formatter);
            } catch (DateTimeException e) {
                System.out.println("Incorrect date format, please input date format as " + settings.getDateFormat() + "\n");
            }
            System.out.println("Input commands, separate by ',' :");
            String[] commandsStr = scanner.nextLine().split(",");
            Commands commands = new Commands();
            for (String command: commandsStr){
                commands.addCommand(command);
            }
            switch (menu1){
                case 1:
                    animal = new Cat(name, dateOfBirth, commands);
                    break;
            }
        } else {
            System.out.println("Wrong number");
        }
        return animal;
    }


}