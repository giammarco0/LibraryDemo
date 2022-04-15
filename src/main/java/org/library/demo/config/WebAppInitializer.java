package org.library.demo.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext(); /**
                                                                                                    * Viene creata un'istanza del contesto web
                                                                                                    */
        System.out.println("***********Context creato|| WebAppInitializer.onStartup--25");

        root.scan("org.library.demo"); /**
                                                     * Si imposta una directory da scansionare
                                                     */

        System.out.println("***********Creato path 'root' || WebAppInitializer.onStartup--31");

        servletContext.addListener(new ContextLoaderListener(root));  /**
                                                                        * Si setta il contesto a root (directory di sopra)
                                                                        */

        System.out.println("***********Settato il contesto a 'root' || WebAppInitializer.onStartup--37");


        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("libraryApp", new DispatcherServlet(new GenericWebApplicationContext()));  /** registrazione nuova DispatcherServlet chiamato "libraryApp" */

        System.out.println("***********Nuova servlet registrata || WebAppInitializer.onStartup--43");

        appServlet.setLoadOnStartup(1);   /**
                                            * all'avvio viene istanziata una sola DispatcherServlet
                                            */

        System.out.println("***********Settato a 1 il numero di DispatcherServlet istanziate automaticamente || WebAppInitializer.onStartup--43");



        appServlet.addMapping("/");   /**
                                               * verranno prese in considerazione le chiamate successive allo "/" finale
                                               * nel link http://localhost:8080/
                                               */

        System.out.println("***********Add mapping '/' || WebAppInitializer.onStartup--49");
    }
}
