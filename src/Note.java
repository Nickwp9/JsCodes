import java.util.ArrayList;
import java.util.Arrays;


public class Note {
    public static void main(String[] args){
    int[] note = {9, 7, 10, 4, 8, 6, 10, 5};
    ArrayList<Integer> promovare = new ArrayList<>();
    for(int n:note){
        if(n>=5){
            promovare.add(n);
        }
    }

        System.out.println(promovare + " -> " + promovare.size() + " note");
    promovare.add(0, 10);
        System.out.println(promovare + " -> " + promovare.size() + " note");
        while(promovare.contains(10)){
            promovare.remove(Integer.valueOf(10));
        }
        System.out.println(promovare + " -> " + promovare.size() + " note");
}
}