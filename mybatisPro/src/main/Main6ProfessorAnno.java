package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapperAnno.ProfessorMapperAnno;
import model.Professor;

public class Main6ProfessorAnno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlmap = Main1.initMybatis();
		SqlSession session = sqlmap.openSession();
		
		int num = session.getMapper(ProfessorMapperAnno.class).count();
		System.out.println("1. professor 테이블의 레코드 개수: "+num);
		System.out.println("2. professor 테이블에 등록된 모든 정보를 출력");
		List<Professor> list = session.getMapper(ProfessorMapperAnno.class).list();
		for(Professor p : list) {
			System.out.println(p);
		}
		System.out.println("2. 교수중 101번 학과의 교수 정보를 출력");
		list = session.getMapper(ProfessorMapperAnno.class).selectdeptno(101);
		for(Professor p : list) {
			System.out.println(p);
		}
		System.out.println("4. 교수중 성이 김씨인 조교수 정보를 출력하기");
		Map<String,Object> map = new HashMap<>();
		map.put("name", "김");
		map.put("position", "조교수");
		list = session.getMapper(ProfessorMapperAnno.class).selectnameposition(map);
		for(Professor p : list) {
			System.out.println(p);
		}
		System.out.println("5. 전임강사이고 101,201 학과인 교수의 정보출력");
		List<Integer> ali = Arrays.asList(101,201);
			map.put("position", "전임강사");
			map.put("datas", ali);
		list = session.getMapper(ProfessorMapperAnno.class).select(map);
		for(Professor p : list) {
			System.out.println(p);
		}
		
	}

}
