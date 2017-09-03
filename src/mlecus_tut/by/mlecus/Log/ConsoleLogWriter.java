package mlecus_tut.by.mlecus.Log;

/**
 * Created by mlecus on 03.09.2017.
 */
public class ConsoleLogWriter implements ILogWriter {
    @Override
    public void Writeln(String message) {
        System.out.println(message);
    }

    @Override
    public void OpenLog(String logPath) {

    }

    @Override
    public void CloseLog() {

    }
}
