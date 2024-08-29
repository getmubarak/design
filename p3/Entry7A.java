package problem3;

interface Connection{ 
  Transaction createTran(); <-- factory method 
  Open();
  Close();
}
interface SqlTransaction{
	Command createCmd(); <-- factory method 
  Begin();
  Commit();
}
interface SqlCommand{
  execute();
}
  
interface Factory{
	Connection createCon();
}
class SqlFactory implements Factory{
  Connection createCon(){
      return new SqlConnection();
  }
}
class OraFactory implements Factory{
  Connection createCon(){
      return new OraConnection();
  }
}
public class Entry {
	public static void main() {
		DoJob(new SqlFactory());
	}
	void DoJob(Factory f)
	{
		Connection connection = f.createCon();
		connection.open("mydb;scott;tiger");
		Transaction transaction = connection.createTran();
		transaction.begin(connection);
		
		Command cmd1 = transaction.createCmd();
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");

		Command cmd2 =  transaction.createCmd();
		cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		
		transaction.commit();
		
		Transaction transaction2 = connection.createTran();
		transaction2.begin(connection);
		
		Command cmd3 = transaction.createCmd();
		cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");

		transaction2.commit();
		connection.close();
		
	}
}
