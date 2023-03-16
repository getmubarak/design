double getSalary(int empCode)
{
	Repostory repo = new Repository();
	repo.connect();
	repo.authenticate();
	Emp emp = rep.get(empCode);
	return emp.getSalary();
}
