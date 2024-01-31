package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    private static final PacManSprites SPRITE_STORE = new PacManSprites();
    private final PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
    private final Player curPlayer = Factory.createPacMan();
    private final GhostFactory gf = new GhostFactory(SPRITE_STORE);

    //given test
    @Test
    void isAlive() {
        assertThat(curPlayer.isAlive()).isEqualTo(true);
    }

    //test 1
    @Test
    void testSetAlive() {
        curPlayer.setAlive(true);
        assertThat(curPlayer.isAlive()).isEqualTo(true);

        curPlayer.setAlive(false);
        curPlayer.setKiller(gf.createBlinky());
        assertThat(curPlayer.isAlive()).isEqualTo(false);
        assertThat(curPlayer.getKiller()).isNotNull();
    }

    //test 2
    @Test
    void testGetScore() {
        assertThat(curPlayer.getScore()).isEqualTo(0);


        curPlayer.addPoints(5);
        assertThat(curPlayer.getScore()).isEqualTo(5);
    }
}
