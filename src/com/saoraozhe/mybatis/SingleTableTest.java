package com.saoraozhe.mybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.saoraozhe.mybatis.entity.Message;

public class SingleTableTest {
	
	public static void main(String[] arg) throws Exception {
		 SingleTableTest.queryMessageList();
//		dao.deleteOne() ;
//		dao.deleteBatch();
	}
	
	public static List<Message> queryMessageList() {
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			//将对象作为参数传递给Mybatis的sqlSession
			Message message = new Message("1");
			sqlSession = MybatisUtil.getSqlSession();
			// 通过namespace加指令标签的 id ，找到xml中配置的一条sql指令
			messageList = sqlSession.selectList("Message.queryMessageList", message);
           System.out.println(messageList.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	
	public static void deleteOne() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			// 基本类型作为参数传递给Mybatis的sqlSession
			sqlSession.delete("Message.deleteOne", 1);
			//提交事务
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	public static void deleteBatch() {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			// List作为参数传递给Mybatis的sqlSession
			sqlSession.delete("Message.deleteBatch", ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}
