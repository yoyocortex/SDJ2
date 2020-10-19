package radiator;

public class Radiator
{
  private RadiatorState currentState = new OffState();

  public void turnUp() {
    currentState.turnUp(this);
  }

  public void turnDown() {
    currentState.turnDown(this);
  }

  public int getPower() {
    return currentState.getPower();
  }

  public void setPowerState(RadiatorState state) {
    currentState = state;
  }
}
