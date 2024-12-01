package dao;

import java.util.List;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class MemberDao {

    private final SqlSessionFactory sqlSessionFactory;

    public MemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(Member member){
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.insert("mapper.member.insert", member);
            sqlSession.commit();  // Commit after insertion
        }
        return result;
    }

    public int update(Member member){
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.update("mapper.member.update", member);
            sqlSession.commit();  // Commit after update
        }
        return result;
    }

    public int delete(Member member){
        int result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.delete("mapper.member.delete", member);
            sqlSession.commit();  // Commit after deletion
        }
        return result;
    }

    public List<Member> findAll(){
        List<Member> result;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            result = sqlSession.selectList("mapper.member.findAll");
        }
        return result;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
