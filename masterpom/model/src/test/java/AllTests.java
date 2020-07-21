import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({model.AllTests.class, model.element.AllTests.class, model.element.motionless.AllTests.class})
public class AllTests {

}
