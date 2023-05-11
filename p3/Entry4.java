package problem3;

public class Entry {
	public static void main() {
    Entry entry = new Entry();
    entry.do(new DIEngine());
  }
  public void do(DIEngine DI){  
	Connection connection = DI.get<Connection>();
    	connection.open("mydb;scott;tiger");
    	Transaction transaction = DI.get<Transaction>();
	transaction.begin(connection);
    	Command cmd1 = DI.get<Command>();
	cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");
  	Command cmd2 = DI.get<Command>();
	cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
	transaction.commit();
	Transaction transaction2 = DI.get<Transaction>();
	transaction2.begin(connection);
	Command cmd3 = DI.get<Command>();
	cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");
  	transaction2.commit();
	connection.close();
		
  }
}
