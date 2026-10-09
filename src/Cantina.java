import java.util.Scanner;

public class Cantina {
    static double Zeama = 24.50;
    static int PainePurjoala = 46;
    static int SalataVarza = 18;
    static int Compot = 18;
    static final double TVA = 0.20;
    static final double REDUCERE = 0.15;

    public static void main(String[] args) {
        System.out.println("Meniul de azi: Zeama - " + Zeama + " lei, Paine cu purjoala - "
                + PainePurjoala + " lei, Salata cu varza - " + SalataVarza + " lei, Compot - " + Compot + " lei");
        Scanner input = new Scanner(System.in);

        double subtotal = 0;

        while (true) {
            System.out.print("Selectati 1 pentru zeama, 2 pentru Paine cu purjoala, 3 pentru Salata cu varza si 4 pentru Compot. 0 pentru a iesi din meniu: ");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 0) {
                System.out.println("Ati iesit din meniu.");
                break;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Optiune invalida!");
                continue;
            }

            System.out.print("Introduceti numarul de portii: ");
            int portions = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> subtotal += Zeama * portions;
                case 2 -> subtotal += PainePurjoala * portions;
                case 3 -> subtotal += SalataVarza * portions;
                case 4 -> subtotal += Compot * portions;
            }
        }

        // Read scholarship status, repeat until valid
        boolean bursier = false;
        while (true) {
            System.out.print("Introduceti daca persoana este bursiera (da/nu): ");
            String raspuns = input.nextLine().trim().toLowerCase();
            if (raspuns.equals("da")) {
                bursier = true;
                break;
            } else if (raspuns.equals("nu")) {
                bursier = false;
                break;
            }
            System.out.println("Raspuns invalid, scrieti da sau nu.");
        }

        // Calculations: discount first, then VAT
        double reducere = bursier ? subtotal * REDUCERE : 0;
        double dupaReducere = subtotal - reducere;
        double tva = dupaReducere * TVA;
        double total = dupaReducere + tva;

        // Receipt
        System.out.println("\n===== BON FISCAL =====");
        System.out.printf("Subtotal: %.2f lei%n", subtotal);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("TVA (20%%): %.2f lei%n", tva);
        System.out.printf("Total:    %.2f lei%n", total);

        input.close();
    }
}