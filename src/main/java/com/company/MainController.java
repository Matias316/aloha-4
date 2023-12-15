package com.company;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.command.impl.BrokerCommand;
import com.company.utils.SupportedCommands;

@RestController
public class MainController {

 	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/install")
    public String install(@RequestParam(value = "package") String packageName) {
      
      logger.debug("Package command received...");

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.INSTALL_COMMAND + " " + packageName;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

  @GetMapping("/list")
    public String list() {

      logger.debug("List command received...");

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.LIST_COMMAND;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

  @GetMapping("/remove")
    public String remove(@RequestParam(value = "package") String packageName) {
      
      logger.debug("Remove command received...");

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.REMOVE_COMMAND + " " + packageName;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

    @GetMapping("/end")
    public String end() {

      logger.debug("End command received...");

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.END_COMMAND;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

    //Request example: http://<server>:<port>/depend?package=ABC&dependency=A&dependency=B&dependency=C
    @GetMapping("/depend")
    public String depend(@RequestParam(value = "package") String packageName, @RequestParam(value = "dependency") List<String> dependencies) {

      logger.debug("Depend command received...");

      BrokerCommand brokerCommand = new BrokerCommand();
      String inputCommand = SupportedCommands.DEPEND_COMMAND + " " + packageName + " " + dependencies;
      String result = brokerCommand.executeCommand(inputCommand);

      return String.format(result);
    }

}
