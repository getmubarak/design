package problem3;

interface Factory{
	Connection getCon();
}
class SqlFactory implements Factory{
	Connection getCon(){
		return new SqlConnection();
	}
	...
}
public class Entry {
	public static void main() {
		DoJob(new SqlFactory());
	}
	void DoJob(Factory f)
	{
		Connection connection = f.getCon();
		connection.open("mydb;scott;tiger");
		Transaction transaction = f.getTran();
		transaction.begin(connection);
		
		Command cmd1 = f.getCmd();
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");

		Command cmd2 =  f.getCmd();
		cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		
		transaction.commit();
		
		Transaction transaction2 = f.getTran();
		transaction2.begin(connection);
		
		Command cmd3 = f.getCmd();
		cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");

		transaction2.commit();
		connection.close();
		
	}
}
