package unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    @DisplayName("This is the first case")
    public void case01() {
        // Arrange == Given == Pre condition
        Hello hello = new Hello();
        // Act  == When == Action == Call target method
        String actualResult = hello.hi("supoj");
        // Assert == Validate with expected result
        assertEquals("Hello, supoj", actualResult);
    }

    @Test
    @DisplayName("Test with database ( I = Isolated/Independent)")
    public void case02() {
        Hello hello = new Hello();
        hello.userDB = new UserDB() {
            @Override
            public String getNameById(int id) {
                return "somkiat";
            }
        };
        String name = hello.workWithDb(1);
        assertEquals("somkiat", name);
    }

    @Test
    @DisplayName("Exception when id = 2")
    public void case03() {
        Hello hello = new Hello();
        hello.userDB = new UserDB() {
            @Override
            public String getNameById(int id) {
                throw new UserNotFoundException("Id=" + id + " not found");
            }
        };

        Exception exception = assertThrows(UserNotFoundException.class, () -> hello.workWithDb(2));
        assertEquals("Id=2 not found", exception.getMessage());
    }
}