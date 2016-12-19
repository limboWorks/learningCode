import java.util.Comparator;

public class Bucky_gen2 {

    public static void main(String[] args) {
        System.out.println(max(23,41,3));
        System.out.println(max("apples","tots","chicken"));
    }

    public static <T extends Comparable<T>> T max(T a,T b,T c){
        T max = a;

        if (b.compareTo(a)>0)
            max = b;

        if (c.compareTo(max)>0)
            max = c;

        return max;
        }


    }

