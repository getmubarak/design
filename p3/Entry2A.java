package problem3;

Connection GetConnection(){
  return new SqlConnection();
}
Command GetCommand(){
  return new SqlCommand();
}
Transaction GetTransaction(){
  return new SqlTransaction();
}

public class Entry {
	public static void main() {
		Connection connection = GetConnection();
		connection.open("mydb;scott;tiger");
		Transaction transaction = GetTransaction();
		transaction.begin(connection);
		
		Command cmd1 = GetCommand();
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");

		Command cmd2 = GetCommand();
		cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		
		transaction.commit();
		
		Transaction transaction2 = GetTransaction();
		transaction2.begin(connection);
		
		Command cmd3 = GetCommand();
		cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");

		transaction2.commit();
		connection.close();
		
	}
}
