package com.saoraozhe.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//DAO: data access object，数据访问层
//CURD 创建（Create,Add）、更新（Update,Modify,Edit）、读取（Read,Query,Get）和删除（Delete,Remove）
public class MyDao {

	//增
	public void add(MyModel user) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="insert into user(user_name,age)values(?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, user.getUser_name());
		ptmt.setInt(2, user.getAge());
		ptmt.execute();
	}
	
	//删
	public void remove(Integer id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="delete from user where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	
	//改
	public void update(MyModel user) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql= "update user set user_name=?,age=? where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, user.getUser_name());
		ptmt.setInt(2, user.getAge());
		ptmt.setInt(3, user.getId());
		ptmt.execute();
	}
	
	//查列表,单字段查询
	public List<MyModel> query(String name) throws Exception{
		//泛型，通过<>中传入的类型参数，来确定自己的类型
		List<MyModel> result=new ArrayList<MyModel>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from user  where user_name like ? ");		
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ResultSet rs=ptmt.executeQuery();
		
		MyModel user=null;
		while(rs.next()){
			user=new MyModel();
			user.setId(rs.getInt("id"));
			user.setUser_name(rs.getString("user_name"));
			user.setAge(rs.getInt("age"));
			
			result.add(user);
		}
		return result;
	}
	//查列表,键值对列表查询
	public List<MyModel> query(List<Map<String, Object>> params) throws Exception{
		List<MyModel> result=new ArrayList<MyModel>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from imooc_goddess where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		MyModel user=null;
		while(rs.next()){
			user=new MyModel();
			user.setId(rs.getInt("id"));
			user.setUser_name(rs.getString("user_name"));
			user.setAge(rs.getInt("age"));
			
			result.add(user);
		}
		return result;
	}
	//查详情
	public MyModel get(Integer id) throws SQLException{
		MyModel user=null;
		Connection conn=DBUtil.getConnection();
		String sql="select * from user where id=?";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			user=new MyModel();
			user.setId(rs.getInt("id"));
			user.setUser_name(rs.getString("user_name"));
			user.setAge(rs.getInt("age"));
		}
		return user;
	}
}
