package pos;

import java.sql.*;

public class Database {

	boolean adm = false;
	boolean check = false;
	int id = 2;
	
	public boolean Access(String linput, String pinput) {
		
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
			
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT login, password, adminMode, logged FROM logowanie");
			rs = st.executeQuery(sql);

			
			while(rs.next()) {
				String l = rs.getString("login");	
				String p = rs.getString("password");
				adm = rs.getBoolean("adminMode");
				
				if(linput.equals(l) && pinput.equals(p)) {
					st.executeUpdate("UPDATE logowanie SET logged = true WHERE login ='"+ l +"'");
					check = true;
				} 
			}
		}catch (SQLException e) {
			
			System.out.print(e);
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return check;
	}
	
	public void logOut() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT logged FROM logowanie");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				st.executeUpdate("UPDATE logowanie SET logged = false WHERE logged = true");
			}
		}catch(Exception e) {	
		}
	}
	public String Display() {
		String display = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
			
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT name, surname FROM logowanie WHERE logged = true");
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				display = surname + " " + name;
			}
		} catch(Exception e) {
			System.out.print(e);
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return display;
	}
	
	public void addAccount(String log, String pas, String name, String sur, boolean ad) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
			
		}
		
		try {
			id=id+1;
			Statement st = conn.createStatement();
			
			
			st.executeUpdate("INSERT into logowanie (login, password, adminmode, name, surname, logged, id) VALUES ('"+log+"', '"+pas+"', "+ad+", '"+name+"', '"+ sur +"', "+false+","+id+")");
			
			
			
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void delAccount(String log) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
			
		}
		
		try {
			id=id-1;
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM logowanie WHERE login ='"+log+"'");
			;
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public String barScanner(String n) {
		String bar = null;
		Connection conn = null;
		ResultSet rs = null;
		int i = -1;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
			
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT productname, amount FROM stock WHERE barcode ='"+n+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				bar = rs.getString("productname");
				st.executeUpdate("UPDATE stock SET amount = amount +"+ i + "WHERE barcode = '"+n+"'");
			}
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return bar;
	}
	
	public Double getPrice(String n) {
		double bar = 0;
		Connection conn = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
			
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT price FROM stock WHERE barcode ='"+n+"'");
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				bar = rs.getDouble("price");
			}
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		return bar;
	}
	
	public void cash(Double sum) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT cash FROM payment");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				st.executeUpdate("UPDATE payment SET cash = cash +"+sum+" WHERE id = 1");
			}
		}catch(Exception e) {	
		}
	}
	
	public void card(Double sum) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT card FROM payment");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				st.executeUpdate("UPDATE payment SET card = card +"+sum+" WHERE id = 1");
			}
		}catch(Exception e) {	
		}
	}
	
	public Double checkCash(Double sum) {
		Double diff = 0.0;
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT cash FROM payment");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				diff = sum - rs.getDouble("cash"); 
			}
		}catch(Exception e) {	
		}
		return diff;
	}
	
	public Double checkCard(Double sum) {
		Double diff = 0.0;
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT card FROM payment");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				diff = sum - rs.getDouble("card"); 
			}
		}catch(Exception e) {	
		}
		return diff;
	}
	public void zeroCash() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT cash FROM payment");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				st.executeUpdate("UPDATE payment SET cash = 0 WHERE id = 1");
			}
		}catch(Exception e) {	
		}
	}
	public void zeroCard() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pos1", "postgres", "admin");
		}catch(Exception e) {
            System.out.print(e);
		}
		
		try {
			Statement st = conn.createStatement();
			String sql = ("SELECT card FROM payment");
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				st.executeUpdate("UPDATE payment SET card = 0 WHERE id = 1");
			}
		}catch(Exception e) {	
		}
	}
	
}
