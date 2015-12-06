package com.saoraozhe.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.saoraozhe.mybatis.entity.MessageType;

//一对多关联，一方有一个成员是 多方的实体集合，在一方xml中配有collection
public class OneToManyTest {
	
	public static void main(String[] arg) throws Exception {
		 OneToManyTest.queryMessageList("news");
	}
	public static void queryMessageList(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			MessageType type = new MessageType();
			type.setTname(name);
			List<MessageType> types = sqlSession.selectList("MessageType.queryMessageList", type);
			MessageType resultType =types.get(0);
			System.out.println(resultType.getMessages().size());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}
