package cn.mybatis.mapper;

import cn.mybatis.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;


public class StudentMapperTest {
    private SqlSession sqlSession = null;
    private StudentMapper mapper = null;
    @Before
    public void setUp() throws Exception {
        //创建Properties对象
        Properties prop = new Properties();
        //创建输入流，指向配置文件,getResourceAsStream可以从classpath加载资源
        InputStream fis= Resources.getResourceAsStream("db.properties");
        //加载属性文件
        prop.load(fis);
        String sqlmapconfig = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(sqlmapconfig);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream,"development",prop);
        sqlSession = factory.openSession();
         mapper = sqlSession.getMapper(StudentMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setStuName("gaoxuan");
        student.setStuSex("男");
        student.setStuAge(20);
        student.setUnit("计算机");
        mapper.addStudent(student);
        sqlSession.commit();
    }

    @Test
    public void delStudentById() {
        Student student = new Student();
        student.setId(3);
        mapper.delStudentById(student);
        sqlSession.commit();
    }

    @Test
    public void updateStudentById() {
        Student student = new Student();
        student.setId(3);
        student.setStuName("gaoxuan");
        student.setStuSex("男");
        student.setStuAge(19);
        student.setUnit("计算机");
        mapper.updateStudentById(student);
        sqlSession.commit();
    }

    @Test
    public void selectStudentById() {
        Student student = new Student();
        student.setId(3);
        Student stu =mapper.selectStudentById(student);
        System.out.println(stu);
    }
    @Test
    public void selectStudentByName() {
        Student student = new Student();
        student.setStuName("gaoxuan");
        List<Student> stu =mapper.selectStudentByName(student);
        System.out.println(stu);
    }
}