//*** framework
class State{
   string name;
   map<string,State> transitions;
}
//*************************************

State createStopWatchStateMachine(){
  State idleState = new State("idle");
  State runningState = new State("running");
  State suspendedState = new State("suspended");

  idleState.add("start", runningState);
  runningState.add("stop",idleState);
  runningState.add("pause", suspendedState);
  suspendedState.add("stop", idleState);
  suspendedState.add("resume", runningState);

  return idleState;
}
State fireEvent(State state,string event){
    if (! state.map.contains(event))
          throw new InvalidStateException();

     return map[event];
}

void main(){
  State currentState = createStopWatchStateMachine();
  currentState= fireEvent(currentState,"start");
  currentState= fireEvent(currentState,"pause");
  currentState= fireEvent(currentState,"start");
}
