package prog.Model;

import prog.Settings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animals {
    final private String name;
    final private LocalDate dateOfBirth;
    private Commands commands;

    public Animals(String name, LocalDate dateOfBirth, Commands commands) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Commands getCommands() {
        return commands;
    }

    public void printAnimalInfo(){
        Settings settings = new Settings();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(settings.getDateFormat());
        System.out.printf("Name: %s, Date of Birth: %s, Commands: %s\n", name, dateOfBirth, commands.toString());
    }

    public void printCommands(){
        System.out.println(commands.toString());
    }

}
