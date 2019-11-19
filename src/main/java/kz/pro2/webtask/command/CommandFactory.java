package kz.pro2.webtask.command;

import kz.pro2.webtask.command.impl.EmptyCommand;

public class CommandFactory {
    /**
     * This method is used to find which command to be executed
     *
     * @param action hidden input value from JSP
     * @return if input is null or blank, EmptyCommand() will be returned,
     * else if input is not blank, but cannot find appropriate command, EmptyCommand() will be returned,
     * else if input is not blank and appropriate command was found, this command will be returned
     */
    public static Command defineCommand(String action) {
        Command current;
        if (action == null || action.isBlank()) {
            return new EmptyCommand();
        }
        try {
            CommandType currentType = CommandType.valueOf(action.toUpperCase());
            current = currentType.getCommand();
        } catch (IllegalArgumentException e) {
            current = new EmptyCommand();
        }
        return current;
    }

    /**
     * Private constructor to make sure that no one creates instance of this class
     */
    private CommandFactory() {
        throw new IllegalStateException("Utility Class");
    }
}
