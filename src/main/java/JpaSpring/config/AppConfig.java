package JpaSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //ApplicationContext를 스프링 컨테이너라고 한다.
    //기존에는 AppConfig를 사용해서직접 객첼를 생성하고 DI했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
    //스프링 컨테이너는 @Cofniguration이 붙은 AppConfig를 설정정보로 사용한다.
    //Bean이라 적힌 메서드를 모두 호출해서 반한된 객체를 스프링 컨테이너에 등록한다.
    //빈은 @Bean이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다.

    @Bean
    public String Bean1(){
        return "1번 Bean";
    }
    @Bean
    public String Bean2(){
        return "2번 Bean";
    }
    @Bean
    public String Bean3(){
        return "3번 Bean";
    }

}
