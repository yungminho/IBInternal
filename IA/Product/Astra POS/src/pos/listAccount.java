package pos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class listAccount  {
	
	public String listName(int i)  {
		String name = null;
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
			String sql = ("SELECT name FROM logowanie where id = "+ i);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				name = rs.getString("name");
			}
			
		} catch(Exception e) {
			
		}
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
			
			
		}
		
		return name;
	}
	
	public String listSurname(int i) {
		String surname = null;
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
			String sql = ("SELECT surname FROM logowanie where id = "+ i);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				surname = rs.getString("surname");
			}
			
		} catch(Exception e) {
			
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
		return surname;
	}
	public String listLogin(int i) {
		String login = null;
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
			String sql = ("SELECT login FROM logowanie where id = "+ i);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				login = rs.getString("login");
			}
			
		} catch(Exception e) {
			
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
		return login;
	}
	public String listType(int i) {
		String type = "";
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
			String sql = ("SELECT adminmode FROM logowanie where id = "+ i);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				if(rs.getBoolean("adminmode") == true) {
					type ="Admin";
				}else {
					type = "User";
				}
			}
			
		} catch(Exception e) {
			
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
		return type;
	}
}