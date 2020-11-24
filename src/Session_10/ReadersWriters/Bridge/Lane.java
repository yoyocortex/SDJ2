package Session_10.ReadersWriters.Bridge;

public interface Lane
{
  void enterFromTheLeft(); // allowed, when no cars from the rightare on the lane
  void exitToTheRight(); // a car has left the lane to the right
  void enterFromTheRight(); // allowed, when no cars from the leftare on the lane
  void exitToTheLeft(); // a car has left the lane to the left
}
