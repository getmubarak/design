package problem1;

interface State{
	Start();
	Stop();
	Pause();
	Resume();
}
class BaseState implements State{
	State Start() { throw new InvalidStateException(); }
	State Stop() { throw new InvalidStateException(); }
	State Pause() { throw new InvalidStateException(); }
	State Resume() { throw new InvalidStateException(); }
}
class Idle extends BaseState
	void Start() { //logic 	}
}
class Running extends BaseState{
        void Pause() { // logic }
 	void Stop() { //logic }
}
class Suspended implements State{
       void Resume() { //logic }
	void Stop() { //logic }
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
