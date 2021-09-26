package springs.network.sync;

public class Generator {
    static private int CurrentID = 0;
    static public synchronized int NextID() {
        CurrentID++;
        return CurrentID;
    }
}
