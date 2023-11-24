package utils;

enum SupportedCommands {
    REMOVE_COMMAND("REMOVE"),
    INSTALL_COMMAND("INSTALL"),
    DEPEND_COMMAND("DEPEND"),
    LIST_COMMAND("LIST"),
    END_COMMAND("END"),;

    private final String text;

    SupportedCommands(final String text) {
        this.text = text;
    }

    public String toString(){
        return text;
    }

}

public enum Responses {
    SUCCESSFULLY_REMOVED("successfully removed"),
    SUCCESSFULLY_INSTALLED("successfully installed"),
    ALREADY_INSTALLED("is already installed"),
    ALREADY_REMOVED("is not installed"),
    IN_USE("is still needed");

    private final String text;

    Responses(final String text) {
        this.text = text;
    }

    public String toString(){
        return text;
    }

}