package market.localstoragemarketdata.core.python;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
public class PythonProcessBuilder {
    String threadName;
    private final CommandPython commandPython;

    public PythonProcessBuilder(CommandPython commandPython) {
        this.commandPython = commandPython;
    }
    public PythonProcessBuilder(CommandPython commandPython, boolean buildPythonVenv, String threadName) {
        this.commandPython = commandPython;
        this.threadName = threadName;
        if (buildPythonVenv) {
            buildPythonProcess();
        }
    }

    public String getFolderPath() {
        return System.getProperty("user.dir")+"/venv"; //Build venv in target folder
    }

    public void buildPythonProcess() {
        log.info("[LocalStorageMarketData-{}] Python venv command creation", this.threadName);
        List<String> command = commandPython.getCommand();
        command.add(getFolderPath());
        log.info("[LocalStorageMarketData-{}] Python venv command is created", this.threadName);
        ProcessBuilder builder = new ProcessBuilder(command);
        try {
            log.info("[LocalStorageMarketData-{}] Create python process", this.threadName);
            Process process = builder.start();
            try {
                process.waitFor();
                log.info("[LocalStorageMarketData-{}] Venv is created successfully", this.threadName);
                //TODO: Write logic to retry build python venv
                //TODO: Now it works only on linux
                //TODO: Check that venv was previously created and still exists
                //TODO: Write logic that can find python version in system
                //TODO: We should find python source files, not only alias
                //TODO: python requirements
                //
                //TODO: Remove venv from target and add to .gitignore
            } catch (InterruptedException e) {
                log.error("[LocalStorageMarketData-{}] Retry build python venv", this.threadName);
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
