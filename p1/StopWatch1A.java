package problem1;

public class StopWatch {
	int state = 0;
	const int IDLE=0;
	const int RUNNING=1;
	const int SUSPENDED=2;
	Timer timer = new Timer();
	
	public boolean start()
	{
		if(state != IDLE)
			return false;

		timer.reset();
		timer.start();
		state = RUNNING;
		return true;
	}
	public boolean stop()
	{
		if(state != RUNNING || state!= SUSPENDED)
			return false;
		
		timer.stop();
		state = IDLE;
		return true;
	}
	public boolean pause()
	{
		if(state != RUNNING)
			return false;
		
		timer.stop();
		state = SUSPENDED;
		return true;
	}
	public boolean resume()
	{
		if(state != SUSPENDED)
			return false;
		
		timer.start();
		state = RUNNING;
		return true;
	}
}
