package problem1;

public class StopWatch {
	int state = 0;
	const int IDLE=0;
	const int RUNNING=1;
	const int SUSPENDED=2;
	
	
	public boolean start()
	{
		if(state != IDLE)
			return false;
		
		//logic
		state = RUNNING;
		return true;
	}
	public boolean stop()
	{
		if(state != RUNNING || state!= SUSPENDED)
			return false;
		
		//logic
		state = IDLE;
		return true;
	}
	public boolean pause()
	{
		if(state != RUNNING)
			return false;
		
		//logic
		state = SUSPENDED;
		return true;
	}
	public boolean resume()
	{
		if(state != SUSPENDED)
			return false;
		
		//logic
		state = RUNNING;
		return true;
	}
}
