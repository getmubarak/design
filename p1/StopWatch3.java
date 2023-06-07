package problem1;

int state = 0;
const int IDLE=0;
const int RUNNING=1;
const int SUSPENDED=2;
	
interface State{
}
class Idle implements State{
}
class Running implements State{
}
class Suspended implements State{
}
//=====================================
public class StopWatch {
	//int state = 0;
	State state = new Idle();
	
	public void start()
	{
		if(state != IDLE)
			throw new InvalidStateException();
		
		//logic
		state = new Running();
	}
	public void stop()
	{
		if(state != RUNNING || state!= SUSPENDED)
			throw new InvalidStateException();
		
		//logic
		state = new Idle();
	}
	public void pause()
	{
		if(state != RUNNING)
			throw new InvalidStateException();
		
		//logic
		state = new Suspended();
	}
	public void resume()
	{
		if(state != SUSPENDED)
			throw new InvalidStateException();
		
		//logic
		state = new Running();
	}
}
