package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class BoardTest {
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    public Square s1 = new BasicSquare();
    public Square s2 = new BasicSquare();
    public BoardFactory board;

    @Test
    void testBoard() {
        //test 3
        board = new BoardFactory(SPRITE_STORE);
        Board mockBoard = board.createBoard(new Square[][]{{s1}});

        assertThat(mockBoard.getHeight()).isEqualTo(1);
        assertThat(mockBoard.getWidth()).isEqualTo(1);
        assertThat(mockBoard.invariant()).isEqualTo(true);
    }

}
