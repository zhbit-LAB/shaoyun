package com.zhbit.ImplDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.zhbit.entity.Notice;

public class SelectNotice {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	
	public ArrayList noticeData(){
		ArrayList l=new ArrayList();
		con=BaseDao.getConnection();
		try {
			stmt=con.createStatement();
			String sql="select * from notice ORDER  BY relTime DESC";
			
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 ArrayList line=new ArrayList();
				 Notice ct=new Notice();
				 ct.setTitle(rs.getString("title"));
				 ct.setRelTime(rs.getString("relTime"));
				 ct.setRelPeople(rs.getString("relPeople"));
				 ct.setContent(rs.getString("content"));
				 l.add(ct);
			}
			stmt.close();
			con.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return l;	
	}
}

