StopWatch
->Idle
  # start : running
->running
  # pause : suspended
  # stop : Idle
->Suspended
  # resume : running
  # stop  : Idle

class StateMachineAuthoringTest{
  void createBasicWorkflowTest(){
    StateMachine sm = new StateMachine();
    
    State s1 = new State("Idle");
    State s2 = new State("Running");
    State s3 = new State("Suspended");
    
    sm.add(s1);
    sm.add(s2);
    sm.add(s3);
    
    Transition t1 = new Transition("start",s2);
    Transition t2 = new Transition("pause",s3);
    Transition t3 = new Transition("stop",s1);
    Transition t4 = new Transition("resume",s2);
    
    s1.add(t1);
    s2.add(t2);
    s2.add(t3);
    s3.add(t3);
    s3.add(t4);
  }
}
