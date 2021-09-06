package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Professor;

public class Main5ProfessorXML {
	private final static String NS = "professor2.";
	private static Map map = new HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlmap = Main1.initMybatis();
		SqlSession session = sqlmap.openSession();
		List<Integer> ali = Arrays.asList(101, 201);

		map.put("position", "전임강사");
		map.put("datas", ali);

		List<Professor> list = session.selectList(NS + "select", map);
		for (Professor p : list) {
			System.out.println(p);
		}
		System.out.println();
		
		list = session.selectList("professor.list");
		for (Professor p : list) {
			System.out.println(p);
		}
		System.out.println();
		System.out.println("=======================================");
		
		Professor p1 = list.get(0);
		p1.setName("새로운");
		p1.setPay(330);
		
		int num = session.insert(NS+"insertProfessor",p1);
		list = session.selectList("professor.list");
		for (Professor p : list) {
			System.out.println(p);
		}
				
	}
}
