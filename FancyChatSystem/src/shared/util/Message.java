package shared.util;

import java.io.Serializable;

public class Message implements Serializable
{
  private String text;
  private String fromUser;
  private String toUser;
  private String date_time;

  public Message(String text, String user) {
    this.text = text;
    this.fromUser = user;
  }

  public Message(String fromUser, String toUser, String text, String date_time) {
    this.fromUser = fromUser;
    this.toUser = toUser;
    this.text = text;
    this.date_time = date_time;
  }

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public String getFromUser()
  {
    return fromUser;
  }

  public void setFromUser(String fromUser)
  {
    this.fromUser = fromUser;
  }

  public String getToUser()
  {
    return toUser;
  }

  public void setToUser(String toUser)
  {
    this.toUser = toUser;
  }

  public String getDate_time()
  {
    return date_time;
  }

  public void setDate_time(String date_time)
  {
    this.date_time = date_time;
  }

  @Override public String toString()
  {
    return "Message{" + "text='" + text + '\'' + ", fromUser='" + fromUser
        + '\'' + ", toUser='" + toUser + '\'' + ", date_time='" + date_time
        + '\'' + '}';
  }
}
