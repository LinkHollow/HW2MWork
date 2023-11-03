package prog.Model;

import java.util.ArrayList;
import java.util.List;

public class Commands {
    private List<String> commands = new ArrayList<>();
    public void printCommands(){
        for(String command:commands){
            System.out.printf(command,"  ");
        }
    }
    public void addCommand(String command){
        commands.add(command);
    }

    @Override
    public String toString() {
        String result = new String();
        for (String command:commands) {
            result = result  + command + " ";
        }
        return result;
    }
}
