import java.util.Scanner;

import command.impl.BrokerCommand;
import utils.SupportedCommands;

public class Console {

   public static void main (String[] args) {

        //BrokerCommand receives command and execute them
        BrokerCommand brokerCommand = new BrokerCommand();

        Scanner input = new Scanner(System.in);        
        while (true) {
            String commandLine = input.nextLine();
            brokerCommand.executeCommand(commandLine);
            if (commandLine.equals(SupportedCommands.END_COMMAND)) {
                break;
            }        
        }
        input.close();
    }  

}
