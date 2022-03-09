package problem1;

interface State{
	Start();
	Stop();
	Pause();
	Resume();
}
class Idle implements State{
	void Start() { //logic 	}
	...
}
class Running implements State{
	void Start() { throw new InvalidStateException(); }
	...
}
class Suspended implements State{
	void Start() { throw new InvalidStateException(); }
	...
}
public class StopWatch {
	State state = new Idle();
	
	public void start(){
		state.start();
		state = new Running();
	}
	public void stop(){
		state.stop();
		state = new Idle();
	}
	public void pause(){
		state.pause();
		state = new Suspended();
	}
	public void resume(){
		state.resume();
		state = new Running();
	}
}
