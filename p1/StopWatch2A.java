public class StopWatch {
	int state = 0;
	const int IDLE=0;
	const int RUNNING=1;
	const int SUSPENDED=2;
	
	
	public void start()
	{
		if(state != IDLE)
			throw new InvalidStateException();
		
		//logic
		state = RUNNING;
	}
	public boolean stop()
	{
		if(state != RUNNING || state!= SUSPENDED)
			throw new InvalidStateException();
		
		//logic
		state = IDLE;
	}
	public boolean pause()
	{
		if(state != RUNNING)
			throw new InvalidStateException();
		
		//logic
		state = SUSPENDED;
	}
	public boolean resume()
	{
		if(state != SUSPENDED)
			throw new InvalidStateException();
		
		//logic
		state = RUNNING;
	}
}
