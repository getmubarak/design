package problem1;

interface State{
	Start();
	Stop();
	Pause();
	Resume();
}
class Idle implements State{
	void Start() { //logic 	}
    void Pause() { throw new InvalidStateException(); }
    void Resume() { throw new InvalidStateException(); }
	void Stop() { throw new InvalidStateException(); }
}
class Running implements State{
	void Start() { throw new InvalidStateException(); }
    void Pause() { // logic }
    void Resume() { throw new InvalidStateException(); }
	void Stop() { //logic }
}
class Suspended implements State{
	void Start() { throw new InvalidStateException(); }
    void Pause() { throw new InvalidStateException(); }
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
