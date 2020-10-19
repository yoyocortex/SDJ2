package Session_3.Exercise_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataModel implements  Subject, Runnable{

    private int red, green, yellow;
    private List<Listener> listeners;

    private Random random = new Random();

    public DataModel() {
        listeners = new ArrayList<>();
    }

    public void recalculateData() {
        int first = random.nextInt(100)+1;
        int second = random.nextInt(100)+1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

        red = bottom;
        green = top - bottom;
        yellow = 100 - top;
        System.out.println("red: " + red);
        System.out.println("green: " + green);
        System.out.println("yellow: " + yellow);
        System.out.println("Sum: " + (red + green + yellow));
        updateListeners(red, green, yellow);
    }

    @Override public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    @Override public void removeListener(Listener listener)
    {
        listeners.remove(listener);
    }

    public void updateListeners(int red, int green, int yellow)
    {
        for(Session_3.Exercise_5.Listener listener : listeners)
            listener.update(red, green, yellow);
    }

    @Override public void run()
    {
        while(true)
        {
            recalculateData();
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
