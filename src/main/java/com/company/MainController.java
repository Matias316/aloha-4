package com.company;

import java.util.List;

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
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

  @GetMapping("/list")
    public String list() {

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.LIST_COMMAND;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

  @GetMapping("/remove")
    public String remove(@RequestParam(value = "package") String packageName) {
      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.REMOVE_COMMAND + " " + packageName;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

    @GetMapping("/end")
    public String end() {

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.END_COMMAND;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

    //Request example: http://<server>:<port>/depend?package=ABC&dependency=A&dependency=B&dependency=C
    @GetMapping("/depend")
    public String depend(@RequestParam(value = "package") String packageName, @RequestParam(value = "dependency") List<String> dependencies) {
    
      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.DEPEND_COMMAND + " " + packageName + " " + dependencies;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

}
