package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Student;

public class Main3StudentXML {
	private final static String NS = "student.";
	private static Map map = new HashMap();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlmap = Main1.initMybatis();
		SqlSession session = sqlmap.openSession();

		System.out.println("student table insert");

		Student s = new Student();
		s.setStudno(1111);
		s.setName("¹Úº¸°Ë");
		s.setGrade(3);
		s.setId("gumgum12");
		s.setJumin("7511231196618");
		s.setDeptno1(101);

		// int cnt = session.insert(NS+"insert",s);
		// System.out.println("student record insert: " + cnt);

		s.setGrade(2);
		s.setWeight(75);
		s.setHeight(180);
		s.setProfno(1212);
		s.setStudno(1111);

		// int cnt = session.update(NS+"update",s);
		// System.out.println("student record update: " + cnt);

		// int cnt = session.delete(NS+"delete",1111);
		// System.out.println("student record delete: " + cnt);
		// session.commit();

		List<Student> li = session.selectList(NS + "select", 1111);

		System.out.println("student row count:" + li.size());
		for (Student st : li) {
			System.out.println(st);
		}

		li = session.selectList(NS + "selectRMap");
		System.out.println("student row count:" + li.size());
		for (Student st : li) {
			System.out.println(st);
		}
	}

}
