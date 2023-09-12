package aplication;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st= conn.prepareStatement(
                  "DELETE FROM seller "
				   + "WHERE "
                   + "Id=? ");
			
			st.setInt(1, 9);
			
			int rowsAffectted = st.executeUpdate();
			System.out.println("Feito! Linhas afetadas: " + rowsAffectted);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getLocalizedMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		  }
 	}
}
