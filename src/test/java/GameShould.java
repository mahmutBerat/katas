import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tictactoe.Game;
import tictactoe.GameState;
import tictactoe.Player;
import tictactoe.Status;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@DisplayName("Game adjudicator should ")
public class GameShould {

    @Test
    public void wait_for_x_to_play_first() {
        Game game = new Game();

        assertThat(game.state(), is(new GameState(Status.GAME_ON, Player.X)));
    }

    @Test
    public void alternate_the_players(){
        Game game = new Game();
        game = game.play();
        game = game.play();

        assertThat(game.state(), is(new GameState(Status.GAME_ON, Player.X)));
    }

}