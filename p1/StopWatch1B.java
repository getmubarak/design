package problem1;

public class StopWatch {
	int state = 0;
	const int IDLE=0;
	const int RUNNING=1;
	const int SUSPENDED=2;
	
	
	public boolean start()
	{
		if(state == RUNNING)
			return false;
		if(state == SUSPENDED)
			return false;
        if(state == IDLE)
  		    //logic
  		    state = RUNNING;
  		    return true;
	}
	public boolean stop()
	{
        if(state == IDLE)
            return false;
		if(state == SUSPENDED)
	  	    //logic
		    state = IDLE;
		    return true;
		if(state == RUNNING)
	  	    //logic
		    state = IDLE;
		    return true;
	}
	public boolean pause()
	{
        if(state == IDLE)
			return false;
		if(state == SUSPENDED)
			return false;
		if(state == RUNNING)
  		    //logic
  		    state = SUSPENDED;
  		    return true;
	}
	public boolean resume()
	{
        if(state == RUNNING)
			return false;
		if(state == IDLE)
			return false;
   	    if(state == SUSPENDED)
            //logic
  		    state = RUNNING;
  		    return true;
	}
}
