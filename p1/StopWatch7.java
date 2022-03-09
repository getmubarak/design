package problem1;

interface State{
	State Start();
	State Stop();
	State Pause();
	State Resume();
}
class Idle implements State{
	State Start() { 
		//logic
		return new Running();
	}
	...
}
class Running implements State{
	State Start() { throw new InvalidStateException(); }
	...
}
class Suspended implements State{
	State Start() { throw new InvalidStateException(); }
	...
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
