import praktikum.Bun;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class firTestsBun {
        @Test
        public void getNameIsCorrect() {
            String bunName = "TestBun";
            Bun bun = new Bun(bunName, 100);
            MatcherAssert.assertThat(
                    "Получено некорректное название булочки",
                    bun.getName(),
                    equalTo(bunName)
            );
        }

        @Test
        public void getPriceIsCorrect() {
            float bunPrice = 100;
            Bun bun = new Bun("TestBun", bunPrice);
            MatcherAssert.assertThat(
                    "Получена некорректная стоимость булочки",
                    bun.getPrice(),
                    equalTo(bunPrice)
            );
        }
    }
