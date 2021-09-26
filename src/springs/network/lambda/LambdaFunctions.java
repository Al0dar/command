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
        FuncStrToStr exclaim = (s) -> "Wow: " + s + "!!";
        print("exclaim", exclaim);
        FuncStrToStr ask = (s) -> s + "?";
        print("ask", ask);
        print("Complain", Complain);
        print("Convert", Convert);
    }

    private void print(String str, FuncStrToStr format) {
        String result = format.run(str);
        System.out.println(result);
    }

    private String convert(String s) {
        return "Converted: '" + s + "'";
    }

}
