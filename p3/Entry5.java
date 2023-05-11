package problem3;

class Factory{
  int flag;
  Factory(int flag) {this.flag = flag; }
  Connection createCon(){
    if(flag== 1)
      return new SqlConnection();
    if(flag== 2)
      return new OraConnection();
  }
  Transaction createTran(){
    if(flag== 1)
      return new SqlTransaction();
    if(flag== 2)
      return new OraTransaction();
  }
  Command createCmd(){
    if(flag== 1)
      return new SqlCommand();
    if(flag== 2)
       return new OraCommand();
  }
}

public class Entry {
	public static void main() {
    		Factory factory = new Factory(1);
		Connection connection = factory.createCon(); 
		connection.open("mydb;scott;tiger");

    		Transaction transaction = factory.createTran();
		transaction.begin(connection);
		Command cmd1 = factory.createCmd();
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");
    		Command cmd2 = factory.createCmd();
		cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		transaction.commit();

    		Transaction transaction2 = factory.createTran();
		transaction2.begin(connection);
		Command cmd3 = factory.createCmd();
		cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");
		transaction2.commit();
		connection.close();
		
	}
}
