package com.j1.w3;

import ch.aplu.turtle.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.awt.geom.Point2D.Double;
import java.awt.Color;
import java.lang.Math;

public class TurtleObserverMain {
  public static void main (String[] args) {
    BabyTurtle baby = new BabyTurtle();
    MomTurtle mom = new MomTurtle();
    DadTurtle dad = new DadTurtle();
    TeacherTurtle tc = new TeacherTurtle();
    
    baby.addObserver(mom);
    baby.addObserver(dad);
    baby.addObserver(tc);
    
    for (int i = 0; i <= 1000; i = i + 10) {
      mom.moveTo(0 - i,0 + (i/2));
      dad.moveTo(0 + (i/3),0 - i);
      tc.moveTo(0 + i,0 + (i/4));
      baby.move((100 - (i*2)) * ((int)Math.pow(-1,(i/10))),(-100) * ((int)Math.pow(-1,(1 + (i/10)))));
      // baby.move(100 - i, -100 - i);
      baby.setChanged();
      baby.notifyObservers();
    }
  }
}

class ObserverTurtle extends Turtle implements Observer {
  Double babyCurpos;
  String id;
  public void update(Observable o, Object arg) {
    System.out.println("update() called, count is " + ((Integer)arg).intValue());
    babyCurpos = ((BabyTurtle)o).myCurpos;
    System.out.println("[To: "+id +"] Baby's current pos is " + babyCurpos);
    moveTo(babyCurpos);
  }
}

class MomTurtle extends ObserverTurtle {
  public MomTurtle() {
        setColor(Color.red);
        label("Mom turtle.");
        this.id = "Mom";
  }
}

class DadTurtle extends ObserverTurtle {
  public DadTurtle() {
        setColor(Color.green);
        label("Dad turtle.");
        this.id = "Dad";
  }
}

class TeacherTurtle extends ObserverTurtle {
  public TeacherTurtle() {
        setColor(Color.blue);
        label("Teacher turtle.");
        this.id = "Teacher";
  }
}

class BabyTurtle extends Observable {
  Turtle baby;
  Double myCurpos;
  ArrayList<Observer> obs;
  public BabyTurtle() {
    baby = new Turtle();
    myCurpos = baby.getPos();
    obs = new ArrayList<Observer>();
  }
  public void addObserver (Observer o) {
    obs.add(o);
  }
  protected void setChanged() {
    myCurpos = baby.getPos();
  }
  public void notifyObservers () {
    for(Observer o:obs) {
      o.update(this, 1);
    }
  }
  public void move(int x, int y){
    baby.moveTo(x,y);
  }
}