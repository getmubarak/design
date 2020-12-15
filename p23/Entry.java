double getSalary(int empCode)
{
	Repostory repo = new Repository();
	res = repo.connect();
	if(res == true){
		res = repo.authenticate();
		if(res == true){
			Emp emp = rep.get(empCode);
			if(emp != null){	
				return emp.getSalary();
			}else{
				return 0;
			}
		}else{
			return 0;
		}			
	}else{
		return 0;
	}
}
