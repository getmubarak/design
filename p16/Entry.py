
enum State
{
  opened,
  assigned,
  resolved,
  rejected,
  closed
}
class Bug
{
  int budId;
  string desc;
  State curState;
}


class Entry
{
  public void changeState(Bug bug,State destState)
  {
    if(destState == State.opened && (bug.curState != State.resolved  || bug.curState != State.rejected))
        throw new InvalidStateException();
    //...
    
    bug.curState = destState;
  }
}
