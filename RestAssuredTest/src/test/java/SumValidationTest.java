import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumValidationTest {


        @Test
        public void sumOfCourses() {
            JsonPath js = new JsonPath(PayLoad.mockResponse());

            int count = js.getInt("courses.size()");
            int copies, price;
            int sum=0;
            for(int i=0; i<count; i++) {
                copies = js.getInt("courses["+i+"].copies");
                price = js.getInt("courses["+i+"].price");
                sum += (copies*price);
            }

            System.out.println(sum);
        }

}