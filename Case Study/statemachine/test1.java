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
    
    Action a1 = new EmailAction(...);
    ...
    
    State s1 = new State("Idle",a1,a2,);
    State s2 = new State("Running",a3,null?);
    State s3 = new State("Suspended",null?,null?);
    
    sm.add(s1)
      .add(s2)
      .add(s3);
    
    Transition t1 = new Transition("start",s2,a4);
    Transition t2 = new Transition("pause",s3,null?);
    Transition t3 = new Transition("stop",s1,a5);
    Transition t4 = new Transition("resume",s2,null);
    
    s1.add(t1);
    s2.add(t2)
      .add(t3);
    s3.add(t3)
      .add(t4);
  }
}
