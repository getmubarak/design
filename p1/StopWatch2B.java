public class StopWatch {
	int state = 0;
	const int IDLE=0;
	const int RUNNING=1;
	const int SUSPENDED=2;
	
	
	public void start()
	{
		if(state == RUNNING)
			throw new InvalidStateException();
		if(state == SUSPENDED)
			throw new InvalidStateException();
		if(state == IDLE)		
  		        //timer logic
  		        state = RUNNING;
	}
	public void stop()
	{
		if(state != RUNNING || state!= SUSPENDED)
			throw new InvalidStateException();
		
		//logic
		state = IDLE;
	}
	public void pause()
	{
		if(state != RUNNING)
			throw new InvalidStateException();
		
		//logic
		state = SUSPENDED;
	}
	public void resume()
	{
		if(state != SUSPENDED)
			throw new InvalidStateException();
		
		//logic
		state = RUNNING;
	}
}
