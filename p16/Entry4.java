//*** framework
class State{
   string name;
   map<string,State> transitions;
}
class Definition{
   string name;
   State intialState;
   
}
class Instance{
  Definition sm;
  State currentState;
  Instance(Definition sm){
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

Definition createStopWatchStateMachine(){
  State idleState = new State("idle");
  State runningState = new State("running");
  State suspendedState = new State("suspended");

  idleState.add("start", runningState);
  runningState.add("stop",idleState);
  runningState.add("pause", suspendedState);
  suspendedState.add("stop", idleState);
  suspendedState.add("resume", runningState);

  return new Definition("StopWatch", idleState);
}

void main(){
  Definition stopwatch = createStopWatchStateMachine();
  Instance watch1 =  new Instance(stopwatch);
  Instance watch2 =  new Instance(stopwatch);
  
  watch1.fireEvent("start");
  watch1.fireEvent("pause");
  watch1.fireEvent("start");
  watch2.fireEvent("start");
}
