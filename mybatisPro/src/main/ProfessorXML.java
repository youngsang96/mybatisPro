package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Professor;

public class ProfessorXML {
	private final static String NS = "professor.";
	private static Map map = new HashMap();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlmap = Main1.initMybatis();
		SqlSession session = sqlmap.openSession();
		System.out.println("1. 교수테이블에 등록된 레코드의 건수를 출력하기");
		System.out.println("2. 교수테이블에 등록된 모든 정보를 출력하기");
		
		List<Professor> li = session.selectList(NS + "select");
		System.out.println("student row count:" + li.size());
		for (Professor pf : li) {
			System.out.println(pf);
		}
		System.out.println("===============================================");
		System.out.println();
		System.out.println("3. 교수중 101번 학과의 교수 정보를 출력하기");
		
		li = session.selectList(NS + "select2", 101);
		System.out.println("student row count:" + li.size());
		for (Professor pf : li) {
			System.out.println(pf);
		}
		
		System.out.println("===============================================");
		System.out.println();
		System.out.println("4. 교수중 성이 김씨인 시간강사 정보를 출력하기");
		
		map.put("name", "김");
		map.put("position", "전임강사");
		li = session.selectList(NS + "select3", map);
		System.out.println("student row count:" + li.size());
		for (Professor pf : li) {
			System.out.println(pf);
		}
		
	}

}
