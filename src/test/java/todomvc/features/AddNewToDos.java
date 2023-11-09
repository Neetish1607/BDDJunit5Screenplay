package todomvc.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewToDos {

    @CastMember(name = "Neetish")
    Actor neetish;

    @Test
    @DisplayName("Add a to do item to an empty list")
    void addToEmptyList() {
        neetish.attemptsTo(Open.url("https://todomvc.com/examples/angularjs/#/"),
                Enter.theValue("Buy Some Milk").into(".new-todo").thenHit(Keys.RETURN));
        var todos = neetish.asksFor(Text.ofEach(".todo-list li"));
        assertThat(todos).containsExactly("Buy Some Milk");
    }
}
