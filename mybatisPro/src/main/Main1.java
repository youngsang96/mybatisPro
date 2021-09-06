package main;

import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main1 {
	public static void main(String[] args) {
		initMybatis();
	}
	
	public static SqlSessionFactory initMybatis() {
		SqlSessionFactory sqlMap=null;
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mapperXML/mybatis-config.xml");
			sqlMap = new SqlSessionFactoryBuilder().build(reader);
			System.out.println("ok config");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return sqlMap;
	}
}
