package Practice;


import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        var pattern = "EMP[MSAC]\\d{4}";
        var string = "EMPA1524";
        System.out.println(Pattern.matches(".{3}A.{4}", string));
    }
}
