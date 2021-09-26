package springs.network.lambda;

public class LambdaFunctions {

    private interface FuncStrToStr {
        String run(String s);
    }

    FuncStrToStr Complain = (s) -> "Meh: " + s + " :(";
    FuncStrToStr Convert = (s) -> convert(s);

    public static void test1() {
        System.out.println("[LambdaFunctions.test1]");
        LambdaFunctions x = new LambdaFunctions();
        x.doStuff();
    }

    private void doStuff() {

        // exclaim
        FuncStrToStr exclaim = (s) -> "Wow: " + s + "!!";

        String exclamation = exclaim.run("The World is Flat");
        System.out.println(exclamation);

        print("No, the world is NOT flat", exclaim);

        // ask
        FuncStrToStr ask = (s) -> s + "?";
        print("What is the meaning of life", ask);

        // complain
        print("Oh God, not this again", Complain);

        // convert
        print("Something or nothing", Convert);

    }

    private void print(String str, FuncStrToStr format) {
        String result = format.run(str);
        System.out.println(result);
    }

    private String convert(String s) {
        String[] x = s.split(" ");
        StringBuilder b = new StringBuilder();
        for (String a : x) b.append(a);
        b.reverse();
        String result = "Converted: '" + b.toString() + "'";
        return result;
    }

}
