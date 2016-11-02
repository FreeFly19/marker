import marker.core.config.CoreConfiguration;
import marker.core.dao.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by FreeFly on 02.11.2016.
 */
public class StudentDaoTest {
    StudentDao studentDao = null;

    @BeforeTest
    public void before() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CoreConfiguration.class);
        studentDao = applicationContext.getBean(StudentDao.class);
    }

    @Test
    public void testFindAll() {
        int size = studentDao.findAll().size();

        Assert.assertEquals(size, 40);
    }

    @Test
    public void testGetByPK() {
        String email = studentDao.getByPK(5).getEmail();

        Assert.assertEquals(email, "godzfm@gmail.com");
    }

    @Test
    public void test() {
        studentDao.getByPK(5).getVisits()
                .forEach(visit -> {
                    System.out.println(visit.getDate());
                });
    }
}
