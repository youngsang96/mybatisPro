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
		System.out.println("1. professor ���̺��� ���ڵ� ����: "+num);
		System.out.println("2. professor ���̺� ��ϵ� ��� ������ ���");
		List<Professor> list = session.getMapper(ProfessorMapperAnno.class).list();
		for(Professor p : list) {
			System.out.println(p);
		}
		System.out.println("2. ������ 101�� �а��� ���� ������ ���");
		list = session.getMapper(ProfessorMapperAnno.class).selectdeptno(101);
		for(Professor p : list) {
			System.out.println(p);
		}
		System.out.println("4. ������ ���� �达�� ������ ������ ����ϱ�");
		Map<String,Object> map = new HashMap<>();
		map.put("name", "��");
		map.put("position", "������");
		list = session.getMapper(ProfessorMapperAnno.class).selectnameposition(map);
		for(Professor p : list) {
			System.out.println(p);
		}
		System.out.println("5. ���Ӱ����̰� 101,201 �а��� ������ �������");
		List<Integer> ali = Arrays.asList(101,201);
			map.put("position", "���Ӱ���");
			map.put("datas", ali);
		list = session.getMapper(ProfessorMapperAnno.class).select(map);
		for(Professor p : list) {
			System.out.println(p);
		}
		
	}

}
