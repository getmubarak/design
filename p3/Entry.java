package problem3;
# library
SqlConnection
SqlTransaction
SqlCommand
OraConnection
OraTransaction
OraCommand
	
# client code
public class Entry {
	public static void main() {
		SqlConnection connection = new SqlConnection();
		connection.open("mydb;scott;tiger");
		SqlTransaction transaction = new SqlTransaction();
		transaction.begin(connection);
		
		SqlCommand cmd1 = new SqlCommand();
		cmd1.execute(transaction, "insert into emp values(10,'jack',2500')");

		SqlCommand cmd2 = new SqlCommand();
		cmd2.execute(transaction, "insert into emp values(20,'jill',4300')");
		
		transaction.commit();
		
		SqlTransaction transaction2 = new SqlTransaction();
		transaction2.begin(connection);
		
		SqlCommand cmd3 = new SqlCommand();
		cmd3.execute(transaction, "insert into emp values(10,'jack',2500')");

		transaction2.commit();
		connection.close();
		
	}
}
