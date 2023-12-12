package com.company;

import java.util.Scanner;
import com.company.command.impl.BrokerCommand;
import com.company.utils.SupportedCommands;

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
