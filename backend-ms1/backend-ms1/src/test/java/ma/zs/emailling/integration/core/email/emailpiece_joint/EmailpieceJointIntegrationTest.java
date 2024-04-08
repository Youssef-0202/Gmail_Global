package ma.zs.emailling.integration.core.email.emailpiece_joint;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;
public class EmailpieceJointIntegrationTest {

    String path = "src/test/java/ma/zs/emailling/integration/core/email/emailpiece_joint/EmailpieceJointHappyTest.feature";

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "dev");
    }

  
    @Karate.Test
    Karate saveHappyTest() {
     return Karate.run(path).tags("save");


    }
    @Karate.Test
    Karate findAllHappyTest() {
        return Karate.run(path).tags("findAll");

    }
    @Karate.Test
    Karate deleteHappyTest() {
        return Karate.run(path).tags("delete");

    }
    @Karate.Test
    Karate putHappyTest() {
        return Karate.run(path).tags("put");
    }

}


