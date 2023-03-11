package market.localstoragemarketdata.core.python;

import lombok.extern.slf4j.Slf4j;
import market.localstoragemarketdata.core.python.fixture.CommandPythonFixture;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
class PythonProcessBuilderTest {

    static PythonProcessBuilder pythonProcessBuilder;
    static CommandPython commandPython;

    @BeforeAll
    public static void setUp() {
        commandPython = new CommandPythonFixture().createCommandPython();
        pythonProcessBuilder = new PythonProcessBuilder(commandPython);
    }

    @Test
    void buildPythonProcess() {
        pythonProcessBuilder.buildPythonProcess();
        //TODO: Finish test
    }

    //@Test
    public void deletePythonVenv() {
        String folderPath = pythonProcessBuilder.getFolderPath();
        try {
            FileUtils.deleteDirectory(new File(folderPath));
            log.info("[LocalStorageMarketData] Python venv is deleted");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}