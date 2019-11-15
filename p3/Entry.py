connection =  SqlConnection()
connection.open("mydb;scott;tiger")
transaction =  SqlTransaction()
transaction.begin(connection)
		
cmd1 =  SqlCommand()
cmd1.execute(transaction, "insert into emp values(10,'jack',2500')")

cmd2 =  SqlCommand()
cmd2.execute(transaction, "insert into emp values(20,'jill',4300')")
		
transaction.commit()
connection.close()
