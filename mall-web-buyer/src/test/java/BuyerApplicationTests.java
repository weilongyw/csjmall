import com.csj.framework.MallBuyerApplication_Jar;
import com.csj.framework.mall.entity.SysUser;
import com.csj.framework.mall.service.ISysUserService;
import com.csj.framework.utils.GenerateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallBuyerApplication_Jar.class)
public class BuyerApplicationTests {


    @Autowired
    ISysUserService iSysUserService;

    CountDownLatch countDownLatch = new CountDownLatch(20);

    @Test
    public void test1() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.execute(() -> {
                iSysUserService.cacheUser("2");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
    }

    @Test
    public void test2() {

    }
}
