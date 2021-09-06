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
		System.out.println("1. �������̺� ��ϵ� ���ڵ��� �Ǽ��� ����ϱ�");
		System.out.println("2. �������̺� ��ϵ� ��� ������ ����ϱ�");
		
		List<Professor> li = session.selectList(NS + "select");
		System.out.println("student row count:" + li.size());
		for (Professor pf : li) {
			System.out.println(pf);
		}
		System.out.println("===============================================");
		System.out.println();
		System.out.println("3. ������ 101�� �а��� ���� ������ ����ϱ�");
		
		li = session.selectList(NS + "select2", 101);
		System.out.println("student row count:" + li.size());
		for (Professor pf : li) {
			System.out.println(pf);
		}
		
		System.out.println("===============================================");
		System.out.println();
		System.out.println("4. ������ ���� �达�� �ð����� ������ ����ϱ�");
		
		map.put("name", "��");
		map.put("position", "���Ӱ���");
		li = session.selectList(NS + "select3", map);
		System.out.println("student row count:" + li.size());
		for (Professor pf : li) {
			System.out.println(pf);
		}
		
	}

}
