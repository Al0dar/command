package springs.network.sync.coffee;

public class Kettle {

    public boolean IsBoiled = false;

    public void BoilWater() {
        IsBoiled = false;
        System.out.println("kettle: started boiling water");
        Wait(5000);
        System.out.println("kettle: finished boiling water");
        IsBoiled = true;
    }

    private void Wait(long l) {
        try {
            Thread.sleep(l);
        } catch (Exception e) { }
    }

}
