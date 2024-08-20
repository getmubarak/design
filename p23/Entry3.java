double getSalary(int empCode)
{
	Repostory repo = new Repository();
	repo.connect();
	repo.authenticate();
	Emp emp = rep.get(empCode);
	return emp.getSalary();
}


void do(){
try{
  ....
  double sal = getSalary(empcode);
  ....
}catch(ConnectionException e){
  ...
}catch(AuthenticationException e){
  ...
}catch(EmpNOtFoundException e){
  ....
}
}
