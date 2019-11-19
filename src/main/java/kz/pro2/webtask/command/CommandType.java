package kz.pro2.webtask.command;

import kz.pro2.webtask.command.impl.*;

public enum CommandType {
    LOGIN(new LoginCommand()), REGISTER(new RegisterCommand()), EMPTY(new EmptyCommand()),
    REGISTER_USER(new RegisterUserCommand()), SUBMIT_SURVEY(new SubmitSurveyCommand()),
    LOGOUT(new LogoutCommand());

    CommandType(Command command) {
        this.command = command;
    }

    private Command command;

    public Command getCommand() {
        return command;
    }
}
