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
	State IDLE = new Idle();
	State RUNNING = new Running();
	State SUSPENDED = new Suspended();

	State state = IDLE;
	
	public void start(){
		state.start();
		state = RUNNING;
	}
	public void stop(){
		state.stop();
		state = IDLE;
	}
	public void pause(){
		state.pause();
		state = SUSPENDED;
	}
	public void resume(){
		state.resume();
		state = RUNNING;
	}
}
