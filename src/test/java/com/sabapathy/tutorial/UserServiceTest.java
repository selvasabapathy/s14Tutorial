package com.sabapathy.tutorial;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sabapathy.tutorial.model.Login;
import com.sabapathy.tutorial.model.User;
import com.sabapathy.tutorial.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/user-beans.xml" })
public class UserServiceTest {

  @Autowired
  private UserService userService;

  @Test
  public void testRegister() {
    User user = new User();
    user.setUsername("selva");
    user.setPassword("sabapathy");
    user.setName("Selva Sabapathy");
    user.setEmail("selva.sabapathy@gmail.com");
    user.setAdmin(false);

    int result = userService.register(user);
    Assert.assertEquals(1, result);
  }

  @Test
  public void testLogin() {
    Login login = new Login();
    login.setUsername("selva");
    login.setPassword("password");

    User user = userService.login(login);
    Assert.assertEquals("Selva Sabapathy", user.getName());
  }

}
