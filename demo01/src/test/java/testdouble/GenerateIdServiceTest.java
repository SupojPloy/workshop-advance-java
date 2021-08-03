package testdouble;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GenerateIdServiceTest {

    @Test
    @DisplayName("Demo Stub Random :: ID = XYZ7")
    public void case01() {
        GenerateIdService service = new GenerateIdService();
        service.setRandom(new StubRandom(7));
        String id = service.get();
        assertEquals("XYZ7", id);
    }

    @Test
    @DisplayName("Demo Spay Random :: Called nextInt()")
    public void case02() {
        SpyRandom spyRandom = new SpyRandom();
        GenerateIdService service = new GenerateIdService();
        service.setRandom(spyRandom);
        service.get();
        spyRandom.verify(1);
    }
}

class SpyRandom extends Random {

    private int counter;

    @Override
    public int nextInt(int bound) {
        this.counter++;
        return 77;
    }

    public void verify(int expectedResult) {
        if (this.counter != expectedResult) {
            fail("จำนวนการเรียกใช้งาน method nextInt() ไม่ถูกต้อง");
        }
    }
}

class StubRandom extends Random {

    private final int number;

    public StubRandom(int number) {
        this.number = number;
    }

    @Override
    public int nextInt(int bound) {
        return this.number;
    }
}