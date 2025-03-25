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
		if(state == IDLE)
			throw new InvalidStateException();

		if(state == RUNNING || state== SUSPENDED)
			//logic
			state = IDLE;
	}
	public void pause()
	{
		if(state == IDLE)
			throw new InvalidStateException();
		if(state == SUSPENDED)
			throw new InvalidStateException();
		if(state == RUNNING)
			//logic
			state = SUSPENDED;
	}
	public void resume()
	{
		if(state == IDLE)
			throw new InvalidStateException();
		if(state == RUNNING)
			throw new InvalidStateException();
		
		if(state == SUSPENDED)
			//logic
			state = RUNNING;
	}
}
