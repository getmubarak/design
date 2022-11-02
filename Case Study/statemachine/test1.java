StopWatch
->Idle
  # start : running
->running
  # pause : suspended
  # stop : Idle
->Suspended
  # resume : running
  # stop  : Idle

class DomainEvent{
  int eventId;
  map<String,String> properties;
}
class State{
  String StateId;
  Action onExit;
  Action onEntry;
  map<String,Transition> transitions;
  map<String,EventType> events;
  
  void Add(Transition t){
    transitions.put(t.getEventId(),t);
  }
  void Add(EventType et){
   events.put(et.getEventId(),et);
  }
  State FireEvent(DomainEvent event){
    EventType et=events.get(event.getId());
    et.executeAction();
    Transition t=transitions.get(event.getId());
    onExit();
    t.state.OnEnter();
    return t.state;
  }
}
class StateMachineInstance{
  State current = new State("Initial");
  
  void FireEvent(DomainEvent event){
    current = current.FireEvent(event);
  }
}
class StateMachineAuthoringTest{
  void createBasicWorkflowTest(){
    StateMachineDefinition sm = new StateMachineDefinition();
    
    Action a0 = new NullAction(...);
    Action a1 = new EmailAction(...);
    
    State s1 = new State("Idle",a1,a2);
    State s2 = new State("Running",a3,a0);
    State s3 = new State("Suspended",a0,a0);
    
    sm.add(s1)
      .add(s2)
      .add(s3);
      
    s1.add(new Transition("START",s2));
    s2.add(new Transition("PAUSE",s3))
      .add(new Transition("STOP",s1));
    s3.add(new Transition("STOP",s1))
      .add(new Transition("RESUME",s2));
      
    s1.add(new EventType("START",a4));
    s2.add(new EventType("STOP",a0));
    
    sm.add(new Transition("CREATE",s1,a0));
    XmlSerializer sr = new XmlSeralizer();
    sr.serialize(sm);
  }
  
}
