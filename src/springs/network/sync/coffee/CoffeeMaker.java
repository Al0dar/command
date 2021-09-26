package springs.network.sync.coffee;

public class CoffeeMaker {

    public void MakeCoffee() {

        System.out.println("making coffee");
        Wait(200);

        System.out.println("using kettle to boil water");
        Kettle kettle = new Kettle();
        new Thread(() -> kettle.BoilWater()).start();
        Wait(1000);

        System.out.println("adding sugar");
        Wait(1000);

        System.out.println("adding milk");
        Wait(1500);

        while (!kettle.IsBoiled) {
            System.out.println("waiting for water to boil");
            Wait(1000);
        }

        System.out.println("adding water");
        Wait(2000);

        System.out.println("stirring");
        Wait(1000);

        System.out.println("here's your lovely cup of coffee :)");

    }

    public static void doCoffeeStuff() {
        CoffeeMaker cm = new CoffeeMaker();
        cm.MakeCoffee();
    }

    private void Wait(long l) {
        try {
            Thread.sleep(l);
        } catch (Exception e) { }
    }
    
}
