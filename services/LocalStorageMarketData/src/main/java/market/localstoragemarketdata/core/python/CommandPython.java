package market.localstoragemarketdata.core.python;

import java.util.ArrayList;
import java.util.List;

public class CommandPython {
    List<String> command;

    public CommandPython() {
    }

    public CommandPython(List<String> command) {
        this.command = command;
    }

    public List<String> getCommand() {
        return command;
    }

    public static class Builder {
        String command;
        String flag;
        String venvName;

        public Builder setCommand(String command) {
            this.command = command;
            return this;
        }

        public Builder setFlag(String flag) {
            this.flag = flag;
            return this;
        }

        public Builder setVenvName(String venvName) {
            this.venvName = venvName;
            return this;
        }

        public CommandPython build() {
            List<String> commandElements = new ArrayList<>() {
                {
                    add(command);
                    add(flag);
                    add(venvName);
                }
            };
            return new CommandPython(commandElements);
        }
    }
}
