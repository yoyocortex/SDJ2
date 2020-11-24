package Kingdom.Collection;

import Kingdom.Valuable.Valuable;

public interface GemDeposit
{
  void addToGemDeposit(Valuable Valuable);
  Valuable takeFromGemDeposit(int index);
  Valuable takeFromGemDeposit(Valuable Valuable);
  int getSize();
}
