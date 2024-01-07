package JpaSpring.beanfind;

import JpaSpring.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
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

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean() {
        String[] BeanDefinitionNames = ac.getBeanDefinitionNames();
        for (String x : BeanDefinitionNames) {
            //BeanDefinition은 Bean에 대한 정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(x);

            //BeanDefinition.ROLE_APPLICATION : Application을 개발하기 위해 개발자가 직접 등록한 빈
            // BeanDefinition.INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(x);
                System.out.println("name = " + BeanDefinitionNames + "object = " + bean);
            }

            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(x);
                System.out.println("name = " + BeanDefinitionNames + "object = " + bean);
            }
        }
    }
}
