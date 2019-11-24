import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tictactoe.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static tictactoe.Player.*;
import static tictactoe.Player.O;
import static tictactoe.Square.*;
import static tictactoe.Square.MIDDLE;
import static tictactoe.Status.GAME_ON;
import static tictactoe.Status.SQUARE_ALREADY_PLAYED;


@DisplayName("Game adjudicator should ")
public class GameShould {

    @Test
    public void wait_for_x_to_play_first() {
        Game game = new Game();

        assertThat(game.state(), is(new GameState(GAME_ON, X)));
    }

    @Test
    public void alternate_the_players(){
        Game game = new Game();
        game = game.play(TOP_LEFT);
        game = game.play(MIDDLE);

        assertThat(game.state(), is(new GameState(GAME_ON, X)));
    }

    @Test
    public void not_allow_a_square_already_played(){
        Game game = new Game();
        game = game.play(TOP_LEFT);
        game = game.play(MIDDLE);
        game = game.play(TOP_LEFT);

        assertThat(game.state(), is(new GameState(SQUARE_ALREADY_PLAYED, X)));
    }

}
