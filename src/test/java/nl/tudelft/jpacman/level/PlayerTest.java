package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.npc.ghost.Blinky;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.sprite.Sprite;


import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
public class PlayerTest {
     private static final PacManSprites SPRITE_STORE = new PacManSprites();
     private final PlayerFactory Factory = new PlayerFactory(SPRITE_STORE);
     private final Player curPlayer = Factory.createPacMan();
     private final GhostFactory gf = new GhostFactory(SPRITE_STORE);

     @Test
    void isAlive(){
         assertThat(curPlayer.isAlive()).isEqualTo(true);
     }

     @Test
    void testSetAlive() {
         curPlayer.setAlive(true);
         assertThat(curPlayer.isAlive()).isEqualTo(true);

         curPlayer.setAlive(false);
         curPlayer.setKiller(gf.createBlinky());
         assertThat(curPlayer.isAlive()).isEqualTo(false);
         assertThat(curPlayer.getKiller()).isNotNull();
     }
}
