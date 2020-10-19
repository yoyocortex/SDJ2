package Session_1;

public class RealClock
{
  private int hour, minute, second;
  public RealClock(int h, int m, int s)
  {
    if(h < 0 || h > 24)
      throw new IllegalArgumentException("Invalid hour " + h);
    else
      hour = h;
    if(m < 0 || m > 59)
      throw new IllegalArgumentException("Invalid minute " + m);
    else
      minute = m;
    if(s < 0 || s > 59)
      throw new IllegalArgumentException("Invalid second " + s);
    else
      second = s;
  }
  public void tic()
  {
    if (second < 60)
      second++;
    if (second == 60)
    {
      second = 0;
      if (minute < 60)
        minute++;
      if (minute == 60)
      {
        minute = 1;
        if (hour < 24)
          hour++;
        if (hour == 24)
          hour = 1;
      }
    }
  }

  public void tic(int seconds)
  {
    if(seconds < 0)
      throw new IllegalArgumentException("Invalid seconds " + seconds);
    for(int x = 0; x < seconds; x++)
    {
      tic();
    }
  }

  public String toString()
  {
    String returnString = "";
    if(hour < 10)
      returnString += "0" + hour + ":";
    else
      returnString += hour + ":";
    if(minute < 10)
      returnString += "0" + minute + ":";
    else
      returnString += minute + ":";
    if(second < 10)
      returnString += "0" + second;
    else
      returnString += second;
    return returnString;
  }

  public int getSeconds()
  {
    return second;
  }
}
