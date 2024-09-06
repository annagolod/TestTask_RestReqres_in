package api_tests;

import api.UserController;
import dto.ResponseGetUserListDto;
import dto.UserDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetUsersListTests extends UserController {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void getUserList_validateEmail() {
        Response response = getUsersList(1, 4);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().print());
        ResponseGetUserListDto responseGetUserListDto = response.getBody().as(ResponseGetUserListDto.class);
        UserDto[] userArray = responseGetUserListDto.getData();
        for (int i = 0; i < userArray.length; i++) {
            softAssert.assertTrue(userArray[i].getEmail().endsWith("reqres.in"), "user -->" + userArray[i].getId());
        }
        softAssert.assertAll();
    }
}