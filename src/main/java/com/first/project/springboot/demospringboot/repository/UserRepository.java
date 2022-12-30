package com.first.project.springboot.demospringboot.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.first.project.springboot.demospringboot.dto.User;

@Repository
public class UserRepository {
	
	private static Connection connection;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		if(!ObjectUtils.isEmpty(connection)) {
			
			return connection;
		}
		
		Class.forName("com.mysql.jdbc.Driver");  
		
        connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj","mysql_demo_tnj","Ebrain@20");
		
		return connection;
	}
	
    public void save(User user) throws ClassNotFoundException, SQLException {
    	
        Connection connection = getConnection();
        
        PreparedStatement preparedStatement = connection.prepareStatement("insert into tb_suresh_springboot values(?,?,?,?,?)");
        
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4, user.getMobile());
        preparedStatement.setDouble(5, user.getIncome());

        preparedStatement.executeUpdate();


}
    
  
    
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
    	
    	 Connection connection = getConnection();
    	 
    	 String selectQuery = "select * from tb_suresh_springboot";
    	 
    	  PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
    	 
    	 ResultSet  resultset = preparedStatement.executeQuery();
    	 
    	 List<User> userlist = new ArrayList<User>();
    	 
    	 User details = null;
    	 
 		while (resultset.next()) {
 			
 			details = new User();
 			
 			details.setId(resultset.getInt(1));
 			details.setName(resultset.getString(2));
 			details.setEmail(resultset.getString(3));
 			details.setMobile(resultset.getString(4));
 			details.setIncome(resultset.getDouble(5));
 			
 			userlist.add(details);
    	 
    }
		return userlist;
    

    }
    
    public void update(User user) throws SQLException, ClassNotFoundException {
		
		 Connection connection = getConnection();
		 
		String updateQuery = "update tb_suresh_springboot set email=? where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setInt(2, user.getId());
		
		preparedStatement.executeLargeUpdate();
		

	}
    
    public void delete(User user) throws SQLException, ClassNotFoundException {
    	
    	Connection connection = getConnection();
    	
		String deleteQuery = "delete  from tb_suresh_springboot  where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
		
		preparedStatement.setInt(1, user.getId());
		
		preparedStatement.executeLargeUpdate();
		

	}
    
	public User getById(Integer id) throws SQLException, ClassNotFoundException {

		Connection connection = getConnection();
		
		String selectQuery = "select * from tb_suresh_springboot where id=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		
		preparedStatement.setInt(1, id);
		
		ResultSet resultset = preparedStatement.executeQuery();
		
		User obj = null;
		
		while (resultset.next()) {
			
			obj = new User();
			obj.setId(resultset.getInt(1));
			obj.setName(resultset.getString(2));
			obj.setEmail(resultset.getString(3));
			obj.setMobile(resultset.getString(4));

}
		return obj;

	}
}
