package Session_1;

import java.util.Scanner;

public class Clock
{
  public static void main(String[] args)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the hour; ");
    int hours = scanner.nextInt();
    System.out.print("Enter the minutes; ");
    int minutes = scanner.nextInt();
    System.out.print("Enter the seconds; ");
    int seconds = scanner.nextInt();

    RealClock realClock = new RealClock(hours, minutes, seconds);

    ThreadOneClock clock = new ThreadOneClock(realClock);
    Thread t1 = new Thread(clock);

    ThreadTwoClock clock1 = new ThreadTwoClock(realClock, clock);
    Thread t2 = new Thread(clock1);

    t1.start();
    t2.start();

  }
}
