package org.library.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.library.demo")
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");   /**
                                                                        * Quando viene effettuata una richiesta alla root /
                                                                        * viene mostrato l'index MA NON RISOLVE IL .jsp
                                                                        */
        System.out.println("***********SetViewName 'index' || MvcConfig.addViewControllers--23");
        //registry.addViewController("/home").setViewName("home");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();  /** raccoglie automaticamente tutte le richieste e le risposte da e verso il controller */



        resolver.setPrefix("/"); /** imposta il prefisso del ViewName */
        System.out.println("***********Set prefix || MvcConfig.viewResolver--34");
        resolver.setSuffix(".jsp");  /** imposta il suffisso del ViewName */
        System.out.println("***********Set suffix || MvcConfig.viewResolver--36");
        return resolver;
    }
}
