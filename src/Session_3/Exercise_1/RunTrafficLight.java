package Session_3.Exercise_1;

public class RunTrafficLight
{
  public static void main(String[] args) throws InterruptedException
  {
    TrafficLight trafficLight = new TrafficLight();
    Car car = new Car(trafficLight);
    Pedestrian pedestrian = new Pedestrian(trafficLight);
    trafficLight.start();
  }
}
