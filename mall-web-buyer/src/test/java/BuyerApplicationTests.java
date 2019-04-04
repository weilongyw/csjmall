import com.csj.framework.mall.MallBuyerApplication_Jar;
import com.csj.framework.mall.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallBuyerApplication_Jar.class)
public class BuyerApplicationTests {

    @Autowired
    ISysUserService userService;

    @Test
    public void test1() {

    }

    @Test
    public void test2() {

    }

    public static void main(String[] args) {

    }
}
