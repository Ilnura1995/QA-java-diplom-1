import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;


@RunWith(MockitoJUnitRunner.class)
public class TestsBurger {


        @Mock
        private Bun bun;
        @Mock
        private Ingredient ingredient;
        @Mock
        private Ingredient ingredient2;

        @Test
        public void setBunsIsCorrect() {
            Burger burger = new Burger();
            Mockito.when(bun.getName()).thenReturn("TestBun");
            burger.setBuns(bun);
            MatcherAssert.assertThat(
                    "Булочки не добавлены",
                    bun.getName(),
                    CoreMatchers.equalTo(burger.bun.getName())
            );
        }


        @Test
        public void addIngredientIsCorrect() {
            Burger burger = new Burger();
            burger.addIngredient(ingredient);
            Assert.assertTrue(
                    "Ингредиент не добавлен",
                    burger.ingredients.contains(ingredient)
            );
        }


        @Test
        public void moveIngredientIsCorrect() {
            Mockito.when(ingredient.getName()).thenReturn("TestIngredient");

            Burger burger = new Burger();
            burger.addIngredient(ingredient);
            burger.addIngredient(ingredient2);
            int currentIndex = burger.ingredients.indexOf(ingredient);
            int newIndex = burger.ingredients.indexOf(ingredient2);

            burger.moveIngredient(currentIndex, newIndex);

            MatcherAssert.assertThat(
                    "Ингредиент не перемещается",
                    ingredient.getName(),
                    CoreMatchers.equalTo(burger.ingredients.get(newIndex).getName())
            );
        }


        @Test
        public void removeIngredientIsCorrect() {
            Burger burger = new Burger();
            burger.addIngredient(ingredient);

            int index = burger.ingredients.indexOf(ingredient);
            burger.removeIngredient(index);

            Assert.assertFalse(
                    "Ингредиент не удаляется",
                    burger.ingredients.contains(ingredient)
            );
        }


        @Test
        public void getPriceIsCorrect() {
            Mockito.when(bun.getPrice()).thenReturn(10f);
            Mockito.when(ingredient.getPrice()).thenReturn(20f);
            Burger burger = new Burger();
            burger.setBuns(bun);
            burger.addIngredient(ingredient);
            MatcherAssert.assertThat(
                    "Цена расчитывается некорректно",
                    40f,
                    CoreMatchers.equalTo(burger.getPrice())
            );

        }
        @Test
        public void getReceiptIsCorrect() {
            Mockito.when(bun.getName()).thenReturn("TestBun");
            Mockito.when(bun.getPrice()).thenReturn(20f);
            Mockito.when(ingredient.getName()).thenReturn("TestIngredient");
            Mockito.when(ingredient.getPrice()).thenReturn(10f);
            Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
            String expectedReceipt =
                    "(==== TestBun ====)\n" +
                            "= filling TestIngredient =\n" +
                            "(==== TestBun ====)\n" +
                            "\nPrice: 50,000000\n";

            Burger burger = new Burger();
            burger.setBuns(bun);
            burger.addIngredient(ingredient);
            //System.out.println(burger.getReceipt());
            MatcherAssert.assertThat("Некорректная строка с рецептом",
                    burger.getReceipt(),
                    CoreMatchers.equalTo(expectedReceipt));
        }
    }


