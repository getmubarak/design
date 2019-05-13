void DoJob()
{
	Domain domain = new Domain();
	bool res = domain.fun();
	if(res == true){
		res = domain.fun2(100);
		if(res == true){
			Repostory rep = new Repository();
			Emp emp = rep.get(1);
			if(emp != null){	
				...
			}else{
				…
			}
		}else{
			…
		}			
	}else{
		…
	}
}
