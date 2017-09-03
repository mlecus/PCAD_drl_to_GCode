package mlecus_tut.by.mlecus.Log;

/**
 * Created by mlecus on 03.09.2017.
 */
public interface ILogWriter {
    public void Writeln(String message);
    public void OpenLog (String logPath);
    public void CloseLog ();
}
