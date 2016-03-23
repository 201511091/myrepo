package com.j1.w3;

import ch.aplu.turtle.*;
import java.util.Observer;
import java.util.Observable;

public static TurtleObservermain() {
  public static void main (String[] args) {
    BabyTurtle baby = BabyTurtle();
    MomTurtle mom = new MomTurtle();
    baby.addObserver(mom);
    mom.moveTo(100,100);
    baby.move(100,-100);
    baby.setChanged();
    baby.notifyObservers();
    
  }
}

class MomTurtle extends turtle implements Observer {
  Double babyCurpos;
  public void update(Observable o, Object arg) {
    System.out.println("update() called, count is "+((Integer)arg.intvalue()));
    ((BabyTurtle)o).myCurpos;
    System.out.println("current pos " + babyCurpos);
    moveTo(babyCurpos);
  }
}

class BabyTurtle extends Observable {
  Turtle baby;
  Double myCurpos;
  ArrayList<Observer> obs;
  public BabyTurtle() {
    baby = new Turtle();
    mySurpos = baby.getPos();
    obs = new ArrayList<Observer>();
  }
  public void addObserver (Observer o) {
    obs.add(o);
  }
  protected void setChanged() {
    myCurpos = baby.getPos();
  }
  public void notifyObserver () {
    for(Observer o:obs)
      o.update(this, 1);
  }
  public void move(int x, int y){
    baby.moveTo(x,y)
  }
}