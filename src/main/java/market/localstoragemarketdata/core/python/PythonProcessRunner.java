package market.localstoragemarketdata.core.python;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PythonProcessRunner {

    public CommandPython commandPython;
    public PythonProcessBuilder pythonProcessBuilder;
    public String threadName;

    public PythonProcessRunner() {
        //TODO: Here we assume that CommandPython commandPython is set up via setter.
        //And we run startThread manually
    }

    public PythonProcessRunner(CommandPython commandPython, String threadName) {
        this.threadName = threadName;
        this.commandPython = commandPython;
        startThread();
        //TODO: Create default thread name? Should it work this way?
    }

    public void setCommandPython(CommandPython commandPython) {
        this.commandPython = commandPython;
    }

    public void createPythonVenv() {
        this.pythonProcessBuilder = new PythonProcessBuilder(this.commandPython, true, this.threadName);
    }

    public void startThread() {
        log.info("[LocalStorageMarketData] Start thread {} to create python venv.", this.threadName);
        Thread thread = new Thread(this::createPythonVenv);
        thread.setName("LocalStorageMarketData-"+this.threadName);
        thread.start();
        log.info("[LocalStorageMarketData] Thread {} is running", thread.getName());
        //TODO: When venv is created, thread should be closed
    }
}
