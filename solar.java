import java.util.*;
public class solar {
    public static void main(String arges[]){
        System.out.println(Squares(15324));
    }
    static ArrayList<Integer> Squares(int area){
        ArrayList<Integer> results = new ArrayList<>();
        while(area>0){
        if(Math.sqrt(area)- Math.floor(Math.sqrt(area))==0){
            results.add(area);
            return results;
        }
        else{
            int k = (int)Math.sqrt(area);
            int rem = (int) Math.pow(k , 2);
            results.add(rem);
            area = area - rem;
            
        }
    }

        return results;
    }
}
/*
issauare(area)



*/