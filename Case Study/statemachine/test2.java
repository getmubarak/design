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
	Transition(String id,State endState){
		super(id);
		this.endState = endState;
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
	    currentState.onExit.execute();
	    System.out.print("transition from " + currentState.getId());
	    currentState = trans.endState;
	    System.out.println(" to " + currentState.getId());
		currentState.onEntry.execute();
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
    smi.fireEvent(new DomainEvent("CREATE"));
    smi.fireEvent(new DomainEvent("START"));
    smi.fireEvent(new DomainEvent("STOP"));
    smi.fireEvent(new DomainEvent("START"));
    smi.fireEvent(new DomainEvent("PAUSE"));
    smi.fireEvent(new DomainEvent("PAUSE"));
  }
  
}
