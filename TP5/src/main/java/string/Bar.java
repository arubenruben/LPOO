package string;

import java.util.ArrayList;
import java.util.List;

public abstract class Bar {

    private boolean happyHour;
    private List<BarObserver> observers;

    Bar(){
        this.happyHour=false;
        this.observers=new ArrayList<>();
    }

    abstract public boolean isHappyHour();
    abstract public void startHappyHour();
    abstract public void endHappyHour();

    public void setHappyHour(boolean status) {
        this.happyHour = status;
        //If the happyhour changes Status notify everybody
        this.notifyObservers();


    }
    public boolean getHappyHour(){
        return this.happyHour;
    }

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour())
                observer.happyHourStarted(this);
            else
                observer.happyHourEnded(this);
    }

}
