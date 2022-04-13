package AvajPackage;

import java.util.ArrayList;

public class Tower{
    // private Flyable observers;
    private ArrayList<Flyable> observers = new ArrayList<>();

    // public  void register(Flyable flyable){}
    // public  void unregister(Flyable flyable){}
    // protected void conditionsChanged(){}

    public void register(Flyable flyable)
    {
        observers.add(flyable);
    }
    
    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for(int i = 0; i < observers.size(); i++)
            observers.get(i).updateConditions();
    }
}