package problem1;

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
	State state = new Idle();
	
	public boolean start()
	{
		if(state != IDLE)
			return false;
		
		//logic
		state = new Running();
		return true;
	}
	public boolean stop()
	{
		if(state != IDLE || state!= SUSPENDED)
			return false;
		
		//logic
		state = new Idle();
		return true;
	}
	public boolean pause()
	{
		if(state != RUNNING)
			return false;
		
		//logic
		state = new Suspended();
		return true;
	}
	public boolean resume()
	{
		if(state != SUSPENDED)
			return false;
		
		//logic
		state = new Running();
		return true;
	}
}
