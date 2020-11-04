package test;

import java.sql.*;

public class RegisterDao{
	
	private String dburl= "jdbc:mysql://localhost:3306/items?serverTimezone=UTC";
	private String dbuname="java";
	private String dbpassword="password";
	private String dbdriver="com.mysql.cj.jdbc.Driver";
	static Connection con= null;
	
	
	
	public Connection getConnection() 
	{

		try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(dburl,"java","password");
			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return con;
	}
	
	public void insert(Member member) 
	{
		
		con = getConnection();
		
		
		//String result="Data stored successfully";

		
		 String sql = "insert into item(barcode, name, color, description) values(?,?,?,?)";
		
			
			PreparedStatement ps=null;
			
			
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,member.getBarcode());
				ps.setString(2,member.getName());
				ps.setString(3,member.getColor());
				ps.setString(4,member.getDescription());
				ps.executeUpdate();
				
				
			
				con.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
				//result= "Data not entered, try again";
				
				
			}
		//return result;
	}
	
	
	public Member getLatestProduct() {
		Member m = new Member();
		
		con = getConnection();
		
		String sql = "select * from item";
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				m.setBarcode(rs.getString("barcode"));
				m.setName(rs.getString("name"));
				m.setColor(rs.getString("color"));
				m.setDescription(rs.getString("description"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public boolean checkIfBarcodeExists(String barcode) {
		boolean exists = false;
		
		con = getConnection();
		String sql = "select * from item where barcode=?";
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, barcode);
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				if(barcode.equals(rs.getString("barcode"))) {
					exists = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}
	
	
}

