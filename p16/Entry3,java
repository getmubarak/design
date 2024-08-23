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

class StateMachine{
    string name;
    State initialState;

    StaeMachineInstance createInstance(){
        return new StaeMachineInstance(this, initialState);
    }
}
class StaeMachineInstance{
    StateMachine sm;
    State currentState;
  
    void fireEvent(string event){
      currentState = currentState.fireEvent(event);
    }
}
//*************************************

StateMachine createStopWatchStateMachine(){
  State idleState = new State("idle");
  State runningState = new State("running");
  State suspendedState = new State("suspended");

  idleState.add("start", ()->logic, runningState);
  runningState.add("stop",()->logic, idleState);
  runningState.add("pause",()->logic, suspendedState);
  suspendedState.add("stop",()->logic, idleState);
  suspendedState.add("resume",()->logic, runningState);

  return new StateMachine("StopWatch", idleState);
}

void main(){
  StateMachine sm = createStopWatchStateMachine();
  StateMachineInstance smi =  sm.createInstance();
  
  smi.fireEvent("start");
  smi.fireEvent("pause");
  smi.fireEvent("start");

}
