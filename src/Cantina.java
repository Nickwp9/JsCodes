import java.util.Scanner;

public class Cantina {
    static final double TVA = 0.20;
    static final double REDUCERE = 0.15;


    static class Produs {
        private String nume;
        private double pret;

        Produs(String nume, double pret) {
            this.nume = nume;
            this.pret = pret;
        }

        String getNume() { return nume; }
        double getPret() { return pret; }

        @Override
        public String toString() {
            return nume + " - " + pret + " lei";
        }


        String codScurt() {
            String litere = nume.substring(0, 3).toUpperCase();
            int parteIntreaga = (int) pret;
            return litere + parteIntreaga;
        }
    }

    public static void main(String[] args) {
        Produs[] meniu = {
                new Produs("Zeama", 24.50),
                new Produs("Paine cu purjoala", 46),
                new Produs("Salata de varza", 18),
                new Produs("Compot", 18)
        };
        int[] cnt = new int[meniu.length];

        Scanner input = new Scanner(System.in);

        System.out.println("Meniu: ");
        for (int i = 0; i < meniu.length; i++) {
            System.out.println((i + 1) + " - " + meniu[i]);
        }

        double subtotal = 0;

        while (true) {
            System.out.print("Selectati produsul (1-4). 0 pentru a iesi din meniu: ");
            int choice = Integer.parseInt(input.nextLine());

            if (choice == 0) {
                System.out.println("Ati iesit din meniu.");
                break;
            }

            if (choice < 1 || choice > meniu.length) {
                System.out.println("Optiune invalida!");
                continue;
            }

            System.out.print("Introduceti numarul de portii: ");
            int portions = Integer.parseInt(input.nextLine());

            int idx = choice - 1;
            cnt[idx] += portions;
            subtotal += meniu[idx].getPret() * portions;
        }


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


        double reducere = bursier ? subtotal * REDUCERE : 0;
        double dupaReducere = subtotal - reducere;
        double tva = dupaReducere * TVA;
        double total = dupaReducere + tva;


        System.out.println("\n===== BON FISCAL =====");
        for (int i = 0; i < meniu.length; i++) {
            if (cnt[i] > 0) {
                System.out.printf("%s %s x %d = %.2f%n",
                        meniu[i].codScurt(), meniu[i].getNume(), cnt[i], cnt[i] * meniu[i].getPret());
            }
        }
        System.out.printf("Subtotal: %.2f lei%n", subtotal);
        System.out.printf("Reducere: %.2f lei%n", reducere);
        System.out.printf("TVA (20%%): %.2f lei%n", tva);
        System.out.printf("Total:    %.2f lei%n", total);


        System.out.print("\nSuma achitata de client (lei intregi): ");
        int achitat = Integer.parseInt(input.nextLine());

        int rest = (int) Math.round(achitat - total);
        System.out.println("Rest: " + rest + " lei");

        int b500 = rest / 500;
        rest = rest % 500;
        System.out.println(b500 + " bancnote de 500");

        int b200 = rest / 200;
        rest = rest % 200;
        System.out.println(b200 + " bancnote de 200");

        int b100 = rest / 100;
        rest = rest % 100;
        System.out.println(b100 + " bancnote de 100");

        int b50 = rest / 50;
        rest = rest % 50;
        System.out.println(b50 + " bancnote de 50");

        int b20 = rest / 20;
        rest = rest % 20;
        System.out.println(b20 + " bancnote de 20");

        int b10 = rest / 10;
        rest = rest % 10;
        System.out.println(b10 + " bancnote de 10");

        int b5 = rest / 5;
        rest = rest % 5;
        System.out.println(b5 + " bancnote de 5");

        int b1 = rest;
        System.out.println(b1 + " bancnote de 1");

        input.close();
    }
}