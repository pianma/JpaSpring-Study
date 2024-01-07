package JpaSpring.beanfind;

import JpaSpring.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAll() {
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();
        for (String x : BeanDefinitionNames) {
            Object bean = ac.getBean(x);
            System.out.println("name = " + BeanDefinitionNames + "object = " + bean);
        }
    }
}
