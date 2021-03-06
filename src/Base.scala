import java.sql.{Connection, DriverManager, ResultSet, SQLException}; 

object Base {
	def main(args: Array[String]) {
	  val bzdb = new DataAdapter; 
	  
	  println("Hello, world!");
	  
	  // load the driver
	  classOf[org.postgresql.Driver];
	  
	  // set the database config
	  val conn_str = "jdbc:postgresql:bzaccounts?user=farye&password=g3mst0n3";
	  
	  // setup the connection
	  val conn = DriverManager.getConnection(conn_str);
	  
	  try {
	    // config to be read only
	    val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); 
	    
	    // execute query
	    val rs = statement.executeQuery("SELECT * FROM sites LIMIT 5"); 
	    
	    // Iterate Over ResultSet
	    while(rs.next) {
	      println(rs);
	    }
	  }
	  
	  finally {
	    conn.close;
	  }
	}
}