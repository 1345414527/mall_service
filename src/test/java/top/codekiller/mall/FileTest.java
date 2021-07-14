package top.codekiller.mall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author codekiller
 * @date 2021/7/14 10:25
 * @Description TODO
 */
@RunWith(SpringRunner.class)
public class FileTest {

    @Test
    public void test(){
        String path = this.getClass().getResource("/").getPath();
        int index = path.indexOf("/mall/");
        String str = path.substring(1, index + 6);
        System.out.println(str);
    }
}
