package com.saoraozhe.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//MVC: Model View Controller，模型 视图 控制器
//模型层包含数据的模型和访问数据的业务逻辑，即本包中的Dao,Model,DBUtil
//视图层即JSP
//控制器负责接收请求、调用模型层，选择视图，即servlet和本包中的Action
public class MyAction {

	public void add(MyModel user) throws Exception{
		MyDao dao=new MyDao();
		dao.add(user);
	}

	public void remove(Integer id) throws SQLException{
		MyDao dao=new MyDao();
		dao.remove(id);
	}
	
	public void update(MyModel MyModel) throws Exception{
		MyDao dao=new MyDao();
		dao.update(MyModel);
	}


	public List<MyModel>  query(String name) throws Exception{
		MyDao dao=new MyDao();
		return dao.query(name);
	}
	public List<MyModel> query(List<Map<String, Object>> params) throws Exception{
		MyDao dao=new MyDao();
		return dao.query(params);
	}
	public MyModel get(Integer id) throws SQLException{
		MyDao dao=new MyDao();
		return dao.get(id);
	}
}
