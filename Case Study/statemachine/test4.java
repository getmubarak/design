import java.util.HashMap;
import java.util.Map;

class DomainObject{
	String id;
	DomainObject(String id){
		    this.id = id;
	}
	public String getId() {
		return id;
	}
}
interface Action{
	void execute();
}
class InvalidEventException extends RuntimeException{	
}
class StateTransitionEvent{
	StateMachineType type;
	StateMachineInstance instance;
	Event event;
	LocalDateTime dateTime;
	State beginState;
	State endState;
}
interface StateTransitionListener{	
	void stateChanged(StateTransitionEvent event);
}

//****************************************************************
class NullAction implements Action{
	public void execute() {}
}
class DomainEvent extends DomainObject{
	Map<String,Object> propertyValues = new HashMap<String,Object>();
	DomainEvent(String id){
		super(id);
	}
}
//****************************************************************
class Transition extends DomainObject{
	State endState;
  Rule rule;
  NullRule nullRule = new NulRule();
  Transition(String id,State endState,Rule rule){
		super(id);
		this.endState = endState;
    this.rule = rule;
	}
	Transition(String id,State endState){
		super(id);
		this.endState = endState;
    this.rule = nullRule;
	}
}
class EventAction extends DomainObject{
	Action action;	
	EventAction(String id,Action action){
		super(id);
		this.action = action;
	}
}
//****************************************************************
class State extends DomainObject{
  Action onExit;
  Action onEntry;
  Map<String,Transition> transitions= new HashMap<String,Transition>();
  Map<String,EventAction> events= new HashMap<String,EventAction>();
  
  State(String id){
		super(id);
		this.onEntry = new NullAction();
		this.onExit = new NullAction();
}
  State(String id,Action onEntry, Action onExit){
		super(id);
		this.onEntry = onEntry;
		this.onExit = onExit;
  }
  State add(Transition t){
    transitions.put(t.getId(),t);
    return this;
  }
  State add(EventAction et){
   events.put(et.getId(),et);
   return this;
  }
}
class StateMachine extends State{
	String stateMachineId;
	String name;
  List<StateTransitionListener> stateTransitionListeners;
	
  protected void fireChangeEvent(StateTransitionEvent event) {
		   for (StateTransitionListener cl : stateTransitionListeners) {
		       cl.stateChanged(event);
		    }
	}
	StateMachine(String id){
		super(id);
  }
}
//****************************************************************
class StateMachineInstance{
  StateMachine sm;
  State currentState = sm;
  public StateMachineInstance(StateMachine sm){
    this.sm = sm;
    this.currentState = sm;
  }
  public void fireEvent(DomainEvent event) {
	    if (!currentState.events.containsKey(event.id) 
	    		&& !currentState.transitions.containsKey(event.id)) {
	      throw new InvalidEventException();
	    }
      HandleEvent(event);
      HandleTransition(event);
	}
    void HandleEvent(DomainEvent event) {
      if (!currentState.events.containsKey(event.id)) {
	      return;
	    }
	    EventAction eventAction = currentState.events.get(event.id);
	    eventAction.action.execute();
	  }
    void HandleTransition(DomainEvent event) {
      if (!currentState.transitions.containsKey(event.id)) {
	      return;
	    }
	    Transition trans = currentState.transitions.get(event.id);
      if(! trans.rule.eval(event))
        return;
      
      StateTransitionEvent stateTransitionEvent= new StateTransitionEvent();
	    stateTransitionEvent.beginState= currentState;
	    
	    currentState.onExit.execute();
	    System.out.print("transition from " + currentState.getId());
	    currentState = trans.endState;
	    System.out.println(" to " + currentState.getId());
		  currentState.onEntry.execute();
      
      stateTransitionEvent.endState= currentState;
		  stateTransitionEvent.event= event;
		  stateTransitionEvent.type= type;
		  stateTransitionEvent.instance= this;
		  //stateTransitionEvent.dateTime = 
	    type.fireChangeEvent(stateTransitionEvent);
      
	}
}
interface Rule{
  boolean eval(DomainEvent event);
}
class GreaterRule implements Rule{
  String property; //amount
  double value; //300
  
  boolean eval(DomainEvent event){
      if (!event.properties.containsKey(property)) {
	      return false;
	    }
	    double curValue = (double) event.properties.get(property);
      return curValue > value;
  }
}
class OrRule implements Rule{
  Rule lhs;
  Rule rhs;
  boolean eval(DomainEvent event){
      return lhs.eval(event) || rhs.eval(event);
  }
}
//***************************************************

class StopWatchFactory{
	public StateMachine create(){
	    StateMachine sm = new StateMachine("StopWatch");
	    
	    Action a0 = new NullAction();
	    Action a1 = new NullAction();
	    
	    State s1 = new State("Idle",a1,a0);
	    State s2 = new State("Running",a1,a0);
	    State s3 = new State("Suspended",a0,a0);
	    
	    sm.add(new Transition("CREATE",s1));
	    
      // e.amount > 300 || e.age < 21
      GreaterRule r1 = new GreaterRule("amount", 300);
      LesserRule r2 = new LesserRule("age", 21);
      OrRule r3 = new OrRule(r1,r2);
	    s1.add(new Transition("START",s2,r3));
		  s1.add(new Transition("START",s2));
		
	    s2.add(new Transition("PAUSE",s3))
	      .add(new Transition("STOP",s1));
	    s3.add(new Transition("STOP",s1))
	      .add(new Transition("RESUME",s2));
	      
	    s1.add(new EventAction("START",a1));
	    s2.add(new EventAction("STOP",a0));
	    
	   return sm;
	  }
	  
}

public class StateMachineTest{
  public static void main(String[] args){
    StopWatchFactory factory = new StopWatchFactory();
    StateMachine sm = factory.create();
    StateMachineInstance smi = new StateMachineInstance(sm);
    StateMachineInstance smi2 = new StateMachineInstance(sm);
    StateMachineInstance sm3 = new StateMachineInstance(sm);
    
    smi.fireEvent(new DomainEvent("CREATE"));
    smi2.fireEvent(new DomainEvent("CREATE"));
    smi.fireEvent(new DomainEvent("START"));
    smi.fireEvent(new DomainEvent("STOP"));
    smi.fireEvent(new DomainEvent("START"));
    smi.fireEvent(new DomainEvent("PAUSE"));
    smi.fireEvent(new DomainEvent("PAUSE"));
  }
  
}

class TrackingListener implements StateTransitionListener{
	public void stateChanged(StateTransitionEvent event) {
		//...
	}
}
class PersistenceListener implements StateTransitionListener{
	public void stateChanged(StateTransitionEvent event) {
		//..
	}
}
