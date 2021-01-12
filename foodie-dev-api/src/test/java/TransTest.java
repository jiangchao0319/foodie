import com.imooc.Application;
import com.imooc.service.TestTransService;
import com.imooc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransTest {
    @Autowired
    private UserService userService;

    @Autowired
    private TestTransService testTransService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Test
    public void myTest(){
        testTransService.testPropagationTrans();
    }
}
