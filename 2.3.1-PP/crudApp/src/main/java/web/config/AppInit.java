package web.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {  //class vmesto appConfig.xml
        return new Class<?>[]{
                SpringConfig.class
        };
    }

   @Override
   protected String[] getServletMappings() {
      return new String[]{"/"};
   }

}
