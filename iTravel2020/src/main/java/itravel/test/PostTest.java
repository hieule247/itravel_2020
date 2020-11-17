package itravel.test;

import itravel.model.DataFactory;
import itravel.model.Post;
import org.junit.Test;

import java.util.List;

/**
 * @author Hailian
 * @Poject name iTravel2020
 * @creat2020-11-16 9:05 AM
 */
public class PostTest {
    @Test
    public void test1(){
        List<Post> postList = DataFactory.getInstance().getPostList();
        System.out.println(postList);
    }
}
