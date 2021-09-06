package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Student;

public class Main4StudentXML {
	private final static String NS = "student2.";
	private static Map map = new HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlmap = Main1.initMybatis();
		SqlSession session = sqlmap.openSession();

		List<Student> li = session.selectList(NS + "select");
		// map.put("grade", 1);
		// map.put("height", 175);
		map.put("studno", 9712);
		li = session.selectList(NS + "select2", map);

		map.clear();
		map.put("col", "height"); //3
		map.put("value", 175);

		map.clear();
		map.put("col", "name"); //4
		
		map.clear();
		map.put("grade", 1); //5
		//map.put("height", 170);
		
		map.clear();
		//map.put("grade", 1);
		map.put("height", 170); //6
		map.put("weight", 70);
		
		List<Integer> ali = Arrays.asList(101,201);
		map.clear();
		map.put("col", "deptno1");
		map.put("datas", ali);
		
		li = session.selectList(NS + "select7", map);
		System.out.println("student row count:" + li.size());
		for (Student st : li) {
			System.out.println(st);
		}

	}

}
