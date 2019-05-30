package pl.codementors.finalProject.controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.codementors.finalProject.models.LocalUser;
import pl.codementors.finalProject.models.LocalUserRole;

import static java.lang.Boolean.TRUE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class LocalUserControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getUserList() throws Exception {
        String uri = "/users";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        LocalUser[] localUsers = super.mapFromJson(content, LocalUser[].class);
        assertTrue(localUsers.length > 0);
    }

    @Test
    public void getOneUser() {
        Response resp = RestAssured.get("/users/3");

        int code = resp.getStatusCode();
        System.out.println("Status code is: " + code);
        Assert.assertEquals(code,200);
    }


    @Test
    public void createUser() throws Exception {
        String uri = "/users/add";
        LocalUser localUser = new LocalUser();
        localUser.setId((long) 5);
        localUser.setName("TestUser");
        localUser.setSurname("TestSurname");
        localUser.setLogin("test@user.pl");
        localUser.setPassword("pass");
        localUser.setAccepted(TRUE);
        localUser.setRole(LocalUserRole.ADMIN);

        String inputJson = super.mapToJson(localUser);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        long status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    public void delete() {
        RequestSpecification request = RestAssured.given();

        Response response = request.post("/users/delete/1");
        int code = response.getStatusCode();
        Assert.assertEquals(code,200);

    }

}
