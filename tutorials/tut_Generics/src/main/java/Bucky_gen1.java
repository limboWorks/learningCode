import java.util.*;
public class Bucky_gen1 {
    public static void main(String[] args) {

        Integer[] iArray = {1, 2, 3, 4, 5};
        Character[] cArray = {'b', 'u', 'c', 'k', 'y'};

        printMe(iArray);
        printMe(cArray);

    }

    public static <T> void printMe(T[] x){
        for (T b : x)
            System.out.printf("%s ",b);
        System.out.println();
    }


}
    /* OLD METHOD


        public static void printMe(Integer[] i){
            for (Integer x : i)
                System.out.printf("%s ",x);
            System.out.println();
        }

        public static void printMe(Character[] c){
            for (Character x : c)
                System.out.printf("%s ",x);
            System.out.println();
        }
    }

     */


