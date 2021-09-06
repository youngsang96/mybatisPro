package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Member;

public class Main2MemberXML {
	private final static String NS = "member.";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlmap = Main1.initMybatis();
		SqlSession session = sqlmap.openSession();
		int x = session.selectOne(NS + "count");
		
		System.out.println("count:" +x);
		System.out.println();
		List<Member> li = session.selectList(NS+"list");
		for (Member m : li) {
			System.out.println(m);
		}
		System.out.println();
		
		Member member = session.selectOne(NS+"selectId", "yohesa");
		System.out.println(member);
		System.out.println();
		li = session.selectList(NS+"selectName", "ÀÌ");
		for (Member m : li) {
			System.out.println(m);
		}
		System.out.println();
		
		Map map = new HashMap();
		map.put("name", "ÀÌ");
		map.put("gender", 1);
		li = session.selectList(NS+"selectNameGender",map);
		for (Member m : li) {
			System.out.println(m);
		}
		
	}

}
