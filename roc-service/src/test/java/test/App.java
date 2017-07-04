package test;/**
 * Created by WanPengCheng on 2017/6/28.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

/**
 * @author WanPengCheng
 * @create 2017-06-28-16:49
 **/
public class App {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext( "classpath*:Spring-config.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "classpath*:Spring-config.xml");
        context.start();
        System.out.println("dubbo product begin to start");
        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
