package com.j2.w3;
import java.util.Date;
import com.sd.turtle.WeightTurtle;

public class j2_201511091_w3main {
    public static void main(String[] args) {

	Date d1 = new Date(1996, 02, 21);	
	Date d2 = new Date(2016, 03, 02);
	Date d3 = new Date(2000, 01, 01);
	
	Date[] A = {d1, d2, d3};
	
	Comparator dateComp = new DateComparator();
	Sorter.sort(A, dateComp);
	
	for(int i = 0; i < A.length; i++)
	    System.out.println("A["+i+"]="+A[i]);

        String[] B = {"John", "Adam", "Skrien", "Smith", "Jones"};
        Comparator stringComp = new StringComparator();
        Sorter.sort(B, stringComp);

        Integer[] C = {new Integer(3), new Integer(1), new Integer(4), new Integer(2)};
        Comparator integerComp = new IntegerComparator();
        Sorter.sort(C, integerComp);

        for(int i = 0; i < B.length; i++)
            System.out.println("B["+i+"]="+B[i]);
        for(int i = 0; i < C.length; i++)
            System.out.println("C["+i+"]="+C[i]);
        
        WeightTurtle wt1 = new WeightTurtle(30);
        WeightTurtle wt2 = new WeightTurtle(10);
        WeightTurtle wt3 = new WeightTurtle(20);
        WeightTurtle[] wt = {wt1, wt2, wt3};
        Comparator turtleComp = new TurtleComparator();
        Sorter.sort(wt, turtleComp);
        
        for (int i = 0;i < wt.length;i++)
          System.out.println("wt["+i+"] = "+wt[i].getWeight());

	String[] D = {"John", "Adam", "Skrien", "Smith", "Jones"};
	Comparator rComp = new ReverseComparator(stringComp);
	Sorter.sort(D, rComp);

        for(int i = 0; i < D.length; i++)
            System.out.println("D["+i+"]="+D[i]);	
    }
}

class Sorter {
  public Sorter() {}
    public static void sort(Object[] data, Comparator comp) {
        for(int i = data.length - 1; i >= 1; i--) {
            int indexOfMax = 0;
            for(int j = 1; j <= i; j++) {
                if(comp.compare(data[j], data[indexOfMax]) > 0)
                    indexOfMax = j;
                }
                Object temp = data[i];
                data[i] = data[indexOfMax];
                data[indexOfMax] = temp;
        }
    }
}

interface Comparator {
    public int compare(Object o1, Object o2);
    public boolean equals(Object o);
}

class IntegerComparator implements Comparator {
    public IntegerComparator() {}
    public int compare(Object o1, Object o2) {
        return (Integer)o1 - (Integer)o2;
    }
}

class StringComparator implements Comparator {
    public StringComparator() {}
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        return s1.compareTo(s2);
        //return Integer.parseInt((String) o1) -
        //   Integer.parseInt((String) o2);
    }
}

class DateComparator implements Comparator {
    public DateComparator() {}
    public int compare(Object o1, Object o2) {
      return ((Date) o1).compareTo((Date) o2);
    }
}

class ReverseComparator implements Comparator {
    private final Comparator c;
    public ReverseComparator(Comparator c) {this.c = c; }
    public int compare(Object o1, Object o2) {
        return c.compare(o2, o1);
    }
}

class TurtleComparator implements Comparator {
    public int compare(Object wt1, Object wt2) {
        return ((WeightTurtle)wt1).getWeight() - ((WeightTurtle)wt2).getWeight();
    }
}