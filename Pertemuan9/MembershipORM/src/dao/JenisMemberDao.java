package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.JenisMember;
import java.util.List;

public class JenisMemberDao {
    private final SqlSessionFactory sqlSessionFactory;

    public JenisMemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insert(JenisMember jenisMember){
        int result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.insert("mapper.jenisMemberMapper.insert", jenisMember);
            session.commit();  // It's important to commit after an insert operation
        }
        return result;
    }

    public int update(JenisMember jenisMember){
        int result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.update("mapper.jenisMemberMapper.update", jenisMember);
            session.commit();  // It's important to commit after an update operation
        }
        return result;
    }

    public int delete(JenisMember jenisMember){
        int result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.delete("mapper.jenisMemberMapper.delete", jenisMember);
            session.commit();  // It's important to commit after a delete operation
        }   
        return result;
    }

    public List<JenisMember> findAll(){
        List<JenisMember> result;
        try(SqlSession session = sqlSessionFactory.openSession()){
            result = session.selectList("mapper.jenisMemberMapper.findAll");
        }
        return result;
    }
}
