package com.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.command.impl.BrokerCommand;
import com.company.utils.SupportedCommands;

@RestController
public class MainController {

	@GetMapping("/install")
    public String install(@RequestParam(value = "package") String packageName) {
      
      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.INSTALL_COMMAND + " " + packageName;
      brokerCommand.executeCommand(inputCommand);

      return String.format(inputCommand);
    }

  @GetMapping("/list")
    public String list() {

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.LIST_COMMAND;
      brokerCommand.executeCommand(inputCommand);

      return String.format(inputCommand);
    }

  @GetMapping("/remove")
    public String remove(@RequestParam(value = "package") String packageName) {
      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.REMOVE_COMMAND + " " + packageName;
      brokerCommand.executeCommand(inputCommand);

      return String.format(inputCommand);
    }
}
