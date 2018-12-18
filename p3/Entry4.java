package problem3;

public class Entry {
  public static void Main(){
    do(new SQLFactory());
  }
	public static void do( Factory f) {
  
		Connection connection = f.getCon();
		connection.open("mydb;scott;tiger");
	  
                Transaction transaction = f.getTran();
		transaction.begin(connection);
		
		Command cmd1 = f.getCmd();
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");
		

		Command cmd2 = f.getCmd();
		cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		
		transaction.commit();
		connection.close();
		
	}
}
