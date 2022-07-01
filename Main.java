package mulesoft;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
public static void main(String [] args) {
	createtable.createNewTable();
	insert("AVENGERS","Robert Jr","cris hemsworth    ",2012,"Stanlee");
	insert("CAPTAIN AMERICA","Chris evans","Peggy             ",2011,"stanlee");
	insert("IRON MAN ","Robert Downey Jr","pepper potts",2013,"stanlee");
	insert("Vampire Diaries","lan somerhalder"," elena gilbert        ",2008,"Neeraj Pandey");
	insert("The Originals","Niklaus","Rebekah",2014,"Kabir Khan");
	select.selectAll();
	select.selectactormovie();
}
private static void insert(String moviename,String leadactor,String actress,Integer yearofrelease,String director) {
	Connection con=Dbconnection.connect();
	PreparedStatement ps=null;
	try {
		String sql="INSERT INTO movies(moviename,leadactor,actress,yearofrelease,director) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, moviename);
		ps.setString(2, leadactor);
		ps.setString(3, actress);
		ps.setInt(4,yearofrelease);
		ps.setString(5, director);
		ps.execute();
		System.out.println("Data has been inserted");
	}catch(SQLException e) {
		System.out.println(e.toString());
	}
}
}
