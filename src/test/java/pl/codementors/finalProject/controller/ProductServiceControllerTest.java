package pl.codementors.finalProject.controller;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.codementors.finalProject.models.Product;
import io.restassured.RestAssured;

import static java.lang.Boolean.TRUE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ProductServiceControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] products = super.mapFromJson(content, Product[].class);
        assertTrue(products.length > 0);
    }

    @Test
    public void getOneProduct() {
        Response resp = RestAssured.get("http://localhost/products/1");

        int code = resp.getStatusCode();
        System.out.println("Status code is: " + code);
        Assert.assertEquals(code,200);
    }

    @Test
    public void createProduct() throws Exception {
        String uri = "/products/add/15";
        Product product = new Product();
        product.setId((long) 15);
        product.setName("AppleSamsung");
        product.setDescription("Description of the phone");
        product.setPrice(90.50);
        product.setAvailable(TRUE);
        product.setUrl("https://tinyjpg.com/images/social/website.jpg");
        product.setCart(null);
        product.setSeller(null);
        String inputJson = super.mapToJson(product);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        long status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void delete() {
        RequestSpecification request = RestAssured.given();

        Response response = request.delete("http://localhost:8080/products/delete/3");
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);

    }


}
