package com.saoraozhe.mybatis;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.saoraozhe.mybatis.entity.Message;

//多对一关联，多方有一个成员是 一方实体对象，在多方xml中配有association
public class ManyToOneTest {
	
	public static void main(String[] arg) throws Exception {
		 ManyToOneTest.queryMessageList("news");
	}
	public static void queryMessageList(String name) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			Message message = new Message("2");
			List<Message> messages = sqlSession.selectList("Message.queryMessageType", message);
			for (Message messageResult : messages) {
				//在xml中配置的查询语句，得是链接查询，message里才会带type，否则type为null
				System.out.println(messageResult.getType().getTname());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}
