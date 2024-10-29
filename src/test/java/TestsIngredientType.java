import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class TestsIngredientType {

        private final String typeName;
    @Parameterized.Parameters(name = "Наличие типа {0}")
        public static Object[][] paramsForTest() {
            return new Object[][] {
                    {"SAUCE"},
                    {"FILLING"}
            };
        }
        public TestsIngredientType(String typeName) {
            this.typeName = typeName;
        }
        @Test
        public void ingredientTypeIsCorrectList() {

            MatcherAssert.assertThat("Отсутствует тип " + typeName,
                    IngredientType.valueOf(typeName.toUpperCase()).toString(),
                    equalTo(typeName));
        }
    }


