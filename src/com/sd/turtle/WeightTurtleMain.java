package com.sd.turtle;

import java.awt.Color;
import ch.aplu.turtle.*;

public class WeightTurtleMain {
  public static void main(String args[]){
    WeightTurtle wt = new WeightTurtle(10);
    System.out.println("Hello WeightTurtle");
    wt.addStatusBar(30);
    String msg = "Hello I weight " + wt.getWeight() + " kg.";
    wt.setStatusText(msg);
  }
}