package problem3;

public class Entry {
	public static void main() {
    Entry entry = new Entry();
    entry.do(new SqlConnection(), new SqlTransaction(), new SqlCommand(), new SqlCommand(),
             new SqlTransaction(),new SqlCommand());
  }
  public void do(Connection connection,Transaction transaction,Command cmd1,Command cmd2,
                Transaction transaction2,Command cmd3 ){  
		connection.open("mydb;scott;tiger");
		transaction.begin(connection);
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");
  	cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		transaction.commit();
		transaction2.begin(connection);
		cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");
  	transaction2.commit();
		connection.close();
		
	}
}
