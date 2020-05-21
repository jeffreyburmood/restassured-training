import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {

        JsonPath js = new JsonPath(PayLoad.mockResponse());

        // Print no of courses returned by API

        int count = js.getInt("courses.size()");

        System.out.println(count);

        //Print purchase amount

        int price = js.getInt("dashboard.purchaseAmount");

        System.out.println(price);

        //Print title of first course

        String title = js.getString("courses[0].title");

        System.out.println(title);

        // Print all course titles and prices

        for(int i=0; i<count; i++) {
            title = js.getString("courses["+i+"].title");
            price = js.getInt("courses["+i+"].price");

            System.out.println(title + "  " + price);
        }
        
        //Print number of copies sold by RPA course
        int copies = 0;
        for(int i=0; i<count; i++) {
            title = js.getString("courses["+i+"].title");
            if(title.contentEquals("RPA")) {
                copies = js.getInt("courses["+i+"].copies");
                break;
            }
        }

        System.out.println("Number of copies = " + copies);
    }
}
