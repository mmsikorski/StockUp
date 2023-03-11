package market.localstoragemarketdata.core.python.fixture;

import market.localstoragemarketdata.core.python.CommandPython;

public class CommandPythonFixture {

    public static String DEFAULT_COMMAND = "python3";
    public static String DEFAULT_FLAG = "-m";
    public static String DEFAULT_VENV_NAME = "venv";

    public CommandPython createCommandPython() {
        return new CommandPython.Builder()
                .setCommand(DEFAULT_COMMAND)
                .setFlag(DEFAULT_FLAG)
                .setVenvName(DEFAULT_VENV_NAME)
                .build();
    }
}
