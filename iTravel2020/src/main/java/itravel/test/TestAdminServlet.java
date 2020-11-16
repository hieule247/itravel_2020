package itravel.test;

import itravel.model.Data;
import itravel.model.DataFactory;
import itravel.model.Page;
import itravel.model.User;
import org.junit.Test;

//import jdk.internal.jline.internal.TestAccessible;

/**
 * @author Hailian
 * @Poject name iTravel2020_2
 * @creat2020-11-12 2:47 PM
 */

public class TestAdminServlet {
//需要提供数库类的实例，来调取数据库里的内容
    @Test
    public  void test1(){
        Data data = DataFactory.getInstance();
        System.out.println(data.getPage());
        Page<User> page = data.getPage();
        System.out.println(page);

        data.page(4, 8);

        System.out.println(data.getPage());
        System.out.println(page);

        page.setPageNo(8);

        System.out.println(data.getPage());
        System.out.println(page);

    }
    @Test
    public void test2(){
        Data data = DataFactory.getInstance();
        Page<User> pageUser = data.getPage();

    }


}
