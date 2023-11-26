import java.util.Scanner;

import command.impl.BrokerCommand;
import utils.SupportedCommands;

public class Console {

   public static void main (String[] args) {

        //BrokerCommand receives command and execute them
        BrokerCommand brokerCommand = new BrokerCommand();

        Scanner input = new Scanner(System.in);        
        while (true) {
            String inputCommand = input.nextLine();
            brokerCommand.executeCommand(inputCommand);
            if (inputCommand.equals(SupportedCommands.END_COMMAND)) {
                break;
            }        
        }
        input.close();
    }  

}
