package com.j2.w3;

public class SorterMainV2 {
  public static void main(String[] args) {
    String[] B = {"John", "Adam", "Skrien", "Smith", "Jones"};
    Comparator stringComp = new StringComparator();
    Sorter.sort(B, stringComp);
    
    Integer[] C = {new Integer(3), new Integer(1), new Integer(4), new Integer(2)};
    Comparator integerComp = new IntegerComparator();
    Sorter.sort(C, integerComp);
    
    for(int i = 0; i < B.length; i++) {
      System.out.println("B["+i+"] = "+B[i]);
    }
    for(int i = 0; i < C.length; i++) {
      System.out.println("C["+i+"] = "+C[i]);
    }
  } 
}

class Sorter {
  public Sorter () {}
  public static void sort(Object[] data, Comparator comp) {
    for(int i = data.length - 1; i >= 1; i--) {
      int indexOfMax = 0;
      for(int j = 1; j <= 1; j++) {
        if (comp.compare(data[i], data[indexOfMax]) > 0)
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

class IntegerComparator implements Comparator{
  public int compare(Object o1, Object o2){
    return (Integer)o1 - (Integer)o2;  // int로 다운 캐스팅 불가 객체가 아니기 때문
  }
}

class StringComparator implements Comparator {
  public int compare(Object o1, Object o2) {
    return ((String)o1).compareTo((String)o2);
  }
}