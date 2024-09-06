package api_tests;

import api.UserController;
import dto.UserDto;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends UserController {

    @Test
    public void registrationPositiveTest(){
        UserDto userDto = UserDto.builder()
                .email("tracey.ramos@reqres.in")
                .password("Password123!")
                .build();
        Assert.assertEquals(registrationUser(userDto).getStatusCode(), 200);
    }

    @Test
    public void registrationNegativeTest(){
        UserDto userDto = UserDto.builder()
                .email("tracey.ramos@reqres.in")
                .password("")
                .build();
        Assert.assertEquals(registrationUser(userDto).getStatusCode(), 400);
    }
}