package problem1;

public class StopWatch {
	int flag = 0;
	
	public boolean start()
	{
		if(flag != 0)
			return false;
		
		//logic
		return true;
	}
	public boolean stop()
	{
		if(flag != 1 || flag!= 2)
			return false;
		
		//logic
		return true;
	}
	public boolean pause()
	{
		if(flag != 1)
			return false;
		
		//logic
		return true;
	}
	public boolean resume()
	{
		if(flag != 2)
			return false;
		
		//logic
		return true;
	}
}
