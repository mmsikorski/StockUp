package market.localstoragemarketdata.core.python;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PythonConfig {

    @Bean
    PythonProcessRunner pythonProcessRunner() {
        CommandPython command = new CommandPython.Builder()
                .setCommand("python3")
                .setFlag("-m")
                .setVenvName("venv")
                .build();
        String threadName = "Thread-PythonRunner";
        return new PythonProcessRunner(command, threadName);
    }
}
