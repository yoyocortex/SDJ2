package sharedClasses.transferObject;

import java.io.Serializable;

public class Request implements Serializable
{
  public EventType type;
  public Object arg;
  public Object secondsArg;

  public Request(EventType type, Object arg)
  {
    this.type = type;
    this.arg = arg;
  }

  public Request(EventType type, Object arg, Object secondArg)
  {
    this.type = type;
    this.arg = arg;
    this.secondsArg = secondArg;
  }
}
