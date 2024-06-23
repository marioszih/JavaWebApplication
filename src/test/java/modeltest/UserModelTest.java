package modeltest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;

class UserModelTest {

	@Test
	public void testUserConstructorAndGetters() {
        User user = new User();
        user.setId(1);
        user.setGender("M");
        user.setName("Spyros");
        user.setSurname("Sitaras");
        user.setHomeAddress("Maxalas");
        user.setWorkAddress("Geitonia");
        assertEquals(1, user.getId());
        assertEquals("Spyros", user.getName());
        assertEquals("Sitaras", user.getSurname());
        assertEquals("M", user.getGender());
        assertEquals("Maxalas", user.getHomeAddress());
        assertEquals("Geitonia", user.getWorkAddress());
    }
}
