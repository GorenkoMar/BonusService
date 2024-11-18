import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.BonusService;

public class BonusServiceTest {

  @Test
  void shouldCalculateForRegisteredAndUnderLimit() {
    BonusService service = new BonusService();
    // подготавливаем данные:
    long amount = 1000;
    boolean registered = true;
    long expected = 30;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForRegisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000_000;
    boolean registered = true;
    long expected = 500;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForUnregisteredAndOverLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000_000;
    boolean registered = false;
    long expected = 500;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForUnregisteredAndUnderLimit() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 1_000;
    boolean registered = false;
    long expected = 10;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForRegisteredAndLimitBorder() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 16_666;
    boolean registered = true;
    long expected = 499;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }

  @Test
  void shouldCalculateForUnregisteredAndLimitBorder() {
    BonusService service = new BonusService();

    // подготавливаем данные:
    long amount = 49_999;
    boolean registered = false;
    long expected = 499;

    // вызываем целевой метод:
    long actual = service.calculate(amount, registered);

    // производим проверку (сравниваем ожидаемый и фактический):
    Assertions.assertEquals(expected, actual);
  }


}
