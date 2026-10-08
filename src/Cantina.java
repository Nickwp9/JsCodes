import java.util.Scanner;

public class Cantina {
    static double Zeama = 24.50;
    static int PainePurjoala = 46;
    static int SalataVarza = 18;
    static int Compot = 18;
    static double total = 0;
    int portions = 0;
    static int a = 0;


    public static void main(String[] args) {
        System.out.println("Meniul de azi: Zeama - " + Zeama + " lei, Paine cu purjoala - "
                + PainePurjoala + " lei, Salata cu varza - " + SalataVarza + " lei, Compot - " + Compot + " lei");
        Scanner input = new Scanner(System.in);

        // Main logic of the code
        while (a != 1) {
            System.out.print("Selectati 1 pentru zeama, 2 pentru Paine cu purjoala, 3 pentru Salata cu varza si 4 pentru Compot. 0 pentru a iesi din meniu: ");
            Integer choice = Integer.valueOf(input.nextLine());


            if (choice == 0) {
                System.out.println("Ati iesit din meniu.");
                break;
            }

            System.out.print("Introduceti numarul de portii: ");
            Integer portions = Integer.valueOf(input.nextLine());

            switch (choice) {
                case 1:
                    total += Zeama * portions;
                    break;
                case 2:
                    total += PainePurjoala * portions;
                    break;
                case 3:
                    total += SalataVarza * portions;
                    break;
                case 4:
                    total += Compot * portions;
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }

        // Print the final bill total
        System.out.printf("Total de plata: %.2f lei\n", total);
        input.close();
    }
}
