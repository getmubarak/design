double getSalary(int empCode)
{
	Domain domain = new Domain();
	bool res = domain.fun();
	if(res == true){
		res = domain.fun2(100);
		if(res == true){
			Repostory rep = new Repository();
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
