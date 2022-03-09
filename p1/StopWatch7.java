package problem1;

interface State{
	State Start();
	State Stop();
	State Pause();
	State Resume();
}
class BaseState implements State{
	State Start() { throw new InvalidStateException(); }
	State Stop() { throw new InvalidStateException(); }
	State Pause() { throw new InvalidStateException(); }
	State Resume() { throw new InvalidStateException(); }
}
class Idle extends BaseState{
	State Start() { 
		//logic
		return new Running();
	}
}
class Running extends BaseState{
	State Stop() { 
		//logic
		return new Idle();
	}
	State Pause() { 
		//logic
		return new Suspended();
	}
}
class Suspended extends BaseState{
	State Stop() { 
		//logic
		return new Idle();
	}
	State Resume() { 
		//logic
		return new Running();
	}
}
public class StopWatch {
	State state = new Idle();
	
	public void start(){
		state = state.start();
	}
	public void stop(){
		state = state.stop();
	}
	public void pause(){
		state = state.pause();
	}
	public void resume(){
		state = state.resume();
	}
}
