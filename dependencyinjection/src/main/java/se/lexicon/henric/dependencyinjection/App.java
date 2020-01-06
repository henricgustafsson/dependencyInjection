package se.lexicon.henric.dependencyinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.lexicon.henric.dependencyinjection.config.ComponentScanConfig;
import se.lexicon.henric.dependencyinjection.data_access.StudentDao;
import se.lexicon.henric.dependencyinjection.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
 
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService service = context.getBean(UserInputService.class);
        context.close();
        
    }
}
