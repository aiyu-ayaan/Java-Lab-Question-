package Question;

public class Exp {
    public static void main(String[] args) {
        int steps = 10;
        for (int i = steps; i > 0; i--) {
            for (int k = steps - i; k > 0; k--) {
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

}
