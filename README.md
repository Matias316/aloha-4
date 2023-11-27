# Package manager
Technical interview exercise

## High Level requirements

1. Maintain a record of installed packages and their dependencies. 
2. Support explicitly installing a package in response to a command (unless it is already installed). 
3. Support implicitly installing a package if it is needed to install another package. 
4. Support explicitly removing a package in response to a command (if it is not needed to support other packages). 
5. Support implicitly removing a package if it is no longer needed to support another component.

## Detailed requirements

Before installing a package, automatically install all the packages it requires. Before removing a package, confirm that no other packages require it. Dependent packages must be removed manually before the package can be removed.

## Input description

The input received by your program will contain a sequence of commands, each on a separate line, containing no more than eighty characters. The command names (DEPEND, INSTALL, REMOVE, and LIST) always appear in uppercase starting in column one and the command line separator is one or more spaces. All appropriate DEPEND commands will appear before the occurrence of any INSTALL dependencies. The end of the input is marked by a line containing only the word END. 

Command Syntax: 

``` DEPEND item1 item2 [item3] ``` 

Package item1 depends on package item2 (and item3 or any additional packages).

``` INSTALL item1 ``` 

Installs item1 and any other packages required by item1.

``` REMOVE item1 ``` 

Removes item1 and, if possible, packages required by item1.

``` LIST ``` 

Lists the names of all currently installed packages.

``` END ``` 

Marks the end of input, when used in a line by itself.


## Output description 

Echo each line of input. Follow each echoed INSTALL or REMOVE line with the actions taken in response, making certain that the actions are given in the proper order. For the LIST command, display the names of the components currently installed. For the DEPEND and END commands, no output, except the echo, is produced. For the DEPEND command, there will only be one dependency list per item. 

### Example 
**Input -> Output**

```
DEPEND TELNET TCPIP NETCARD -> DEPEND TELNET TCPIP NETCARD
DEPEND TCPIP NETCARD -> DEPEND TCPIP NETCARD
DEPEND DNS TCPIP NETCARD -> DEPEND DNS TCPIP NETCARD
DEPEND BROWSER TCPIP HTML -> DEPEND BROWSER TCPIP HTML
INSTALL NETCARD -> INSTALL NETCARD NETCARD successfully installed
INSTALL TELNET -> INSTALL TELNET TCPIP successfully installed TELNET successfully installed 
INSTALL foo -> INSTALL foo foo successfully installed
REMOVE NETCARD -> REMOVE NETCARD NETCARD is still needed
INSTALL BROWSER -> INSTALL BROWSER HTML successfully installed BROWSER successfully installed
INSTALL DNS -> INSTALL DNS DNS successfully installed
LIST -> LIST HTML BROWSER DNS NETCARD foo TCPIP TELNET
REMOVE TELNET -> REMOVE TELNET TELNET successfully removed
REMOVE NETCARD -> REMOVE NETCARD NETCARD is still needed
REMOVE DNS -> REMOVE DNS DNS successfully removed
REMOVE NETCARD -> REMOVE NETCARD NETCARD is still needed
INSTALL NETCARD -> INSTALL NETCARD NETCARD is already installed
REMOVE TCPIP -> REMOVE TCPIP TCPIP is still needed
REMOVE BROWSER -> REMOVE BROWSER BROWSER successfully removed HTML is no longer needed HTML successfully removed TCPIP is no longer needed TCPIP successfully removed
REMOVE TCPIP -> REMOVE TCPIP TCPIP is not installed
LIST -> LIST NETCARD foo END
END -> END
```
