//*** framework
class Transition{
  State destination;
  Lamda action;
}

class State{
   string name;
   map<Event,Transition> transitions;
   
  State fireEvent(string event){
      if (! map.contains(event))
          throw new InvalidStateException();

      Transition  transition = map[event];
      transition.action();
      return transition.getDestination();
  }
}

class StateMachineDefinition{
    string name;
    State initialState;

    StaeMachineInstance createInstance(){
        return new StaeMachineInstance(this, initialState);
    }
}
class StaeMachineInstance{
    StateMachineDefinition sm;
    State currentState;
  
    void fireEvent(string event){
      currentState = currentState.fireEvent(event);
    }
}
//*************************************

StateMachineDefinition createStopWatchStateMachine(){
  State idleState = new State("idle");
  State runningState = new State("running");
  State suspendedState = new State("suspended");

  idleState.add("start", ()->logic, runningState);
  runningState.add("stop",()->logic, idleState);
  runningState.add("pause",()->logic, suspendedState);
  suspendedState.add("stop",()->logic, idleState);
  suspendedState.add("resume",()->logic, runningState);

  return new StateMachineDefinition("StopWatch", idleState);
}

void main(){
  StateMachineDefinition stopwatch = createStopWatchStateMachine();
  StateMachineInstance watch1 =  stopwatch.createInstance();
  StateMachineInstance watch2 =  stopwatch.createInstance();
  
  watch1.fireEvent("start");
  watch1.fireEvent("pause");
  watch1.fireEvent("start");
  watch2.fireEvent("start");
}
