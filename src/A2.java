import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduceti nota: ");

        Integer nota = Integer.valueOf(input.nextLine());


        switch (nota) {
            case 1, 2, 3, 4 -> System.out.println("Aceasta nota e nesatisfacatoare.");
            case 5, 6       -> System.out.println("Aceasta nota e satisfacatoare.");
            case 7, 8       -> System.out.println("Aceasta nota e buna");
            case 9, 10      -> System.out.println("Aceasta nota este excelenta.");
            default         -> System.out.println("Nota scrisa nu este admisibila. Selectati din nou");
        }

        input.close();
    }
}
