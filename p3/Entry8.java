package problem3;

interface Connection {
	void open(String connectionString);
	void close();
}
public class SqlConnection implements Connection {
	public void open(String connectionString){
		//logic
	}
	public void close(){
		//logic
	}
}
public class OraConnection  implements Connection {
	public void open(String connectionString){
		//logic
	}
	public void close(){
		//logic
	}
}
//3rd party
public class PostGres{
	public void connect(string str){
		//logic
	}
	public void disconnect(){
		//logic
	}
}
