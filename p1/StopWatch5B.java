package problem1;

interface State{
	Start();
	Stop();
	Pause();
	Resume();
}
class Timer{
  void Start() { // logic  }
  void Pause() { // logic }
  void Resume() { // logic }
	void Stop() { //logic }
}
//*************************************************************
class Idle implements State{
  Timer timer;
  Idle(Timer timer) { this.timer = timer; }
	void Start() { timer.start(); 	}
        void Pause() { throw new InvalidStateException(); }
        void Resume() { throw new InvalidStateException(); }
	void Stop() { throw new InvalidStateException(); }
}
class Running implements State{
  Timer timer;
  Idle(Timer timer) { this.timer = timer; }
	void Start() { throw new InvalidStateException(); }
	void Pause() { timer.Pause(); 	 }
	void Resume() { throw new InvalidStateException(); }
	void Stop() { timer.Stop(); }
}
class Suspended implements State{
  Timer timer;
  Idle(Timer timer) { this.timer = timer; }
	void Start() { throw new InvalidStateException(); }
	void Pause() { throw new InvalidStateException(); }
	void Resume() { timer.Resume(); }
	void Stop() { timer.Stop(); }
}
//*************************************************************
public class StopWatch {
	Timer timer = new Timer();
	State state = new Idle(timer);
	
	public void start(){
		state.start();
		state = new Running(timer);
	}
	public void stop(){
		state.stop();
		state = new Idle(timer);
	}
	public void pause(){
		state.pause();
		state = new Suspended(timer);
	}
	public void resume(){
		state.resume();
		state = new Running(timer);
	}
}
