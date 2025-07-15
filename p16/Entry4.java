//*** framework
class State{
   string name;
   map<string,State> transitions;
}
class StateMachineDefinition{
   string name;
   State intialState;
   
}
class StaeMachineInstance{
  StateMachineDefinition sm;
  State currentState;
  StaeMachineInstance(StateMachineDefinition sm){
    this.sm = sm;
    currentState = sm.intialState;
  }
   void fireEvent(string event){
    if (! currentState.map.contains(event))
          throw new InvalidStateException();

     currentState = map[event];
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
  StateMachineInstance watch1 =  new StaeMachineInstance(stopwatch);
  StateMachineInstance watch2 =  new StaeMachineInstance(stopwatch);
  
  watch1.fireEvent("start");
  watch1.fireEvent("pause");
  watch1.fireEvent("start");
  watch2.fireEvent("start");
}
