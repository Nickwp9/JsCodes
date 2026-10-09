package Exercitiile;

public class Produs{
    private double price;
    private String name;
    private Boolean stock;

    public Produs(double price, String name, Boolean stock){
        this.price = price;
        this.name = name;
        this.stock = stock;

    }
    @Override
    public String toString(){
        return name + " - " + price + " - " + stock;}

    static Produs p = new Produs(95, "Pix", true);
    static Produs mere = new Produs(20, "mere", false);
    static Produs cafea = new Produs(30, "cafea", true);

    public static void main(String args[]){
            System.out.println(p);
            System.out.println(mere);
            System.out.println(cafea);
        }
    }

