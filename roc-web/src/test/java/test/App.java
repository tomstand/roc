package test;/**
 * Created by WanPengCheng on 2017/6/28.
 */

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author WanPengCheng
 * @create 2017-06-28-16:49
 **/
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:Spring-config.xml");
        context.start();
        System.out.println("dubbo consumer begin to start");//根据Xml配置文件创建Resource资源对象，该对象中包含了BeanDefinition的信息
//        ClassPathResource resource =new ClassPathResource("application-context.xml");
////创建DefaultListableBeanFactory
//        DefaultListableBeanFactory factory =new DefaultListableBeanFactory();
////创建XmlBeanDefinitionReader读取器，用于载入BeanDefinition。之所以需要BeanFactory作为参数，是因为会将读取的信息回调配置给factory
//        XmlBeanDefinitionReader reader =new XmlBeanDefinitionReader(factory);
////XmlBeanDefinitionReader执行载入BeanDefinition的方法，最后会完成Bean的载入和注册。完成后Bean就成功的放置到IOC容器当中，以后我们就可以从中取得Bean来使用
//        reader.loadBeanDefinitions(resource);

        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
