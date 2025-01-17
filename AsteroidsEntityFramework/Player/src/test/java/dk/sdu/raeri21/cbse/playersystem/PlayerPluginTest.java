package dk.sdu.raeri21.cbse.playersystem;

import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerPluginTest {
    private static GameData mockedGameData;
    private static World mockedWorld;
    private static PlayerPlugin playerPlugin;

    @BeforeAll
    static void setUp() {
        // Mock GameData and World
        mockedGameData = mock(GameData.class);
        mockedWorld = mock(World.class);

        // Create Instance of the player plugin class
        playerPlugin = new PlayerPlugin();
    }

    @Test
    @Order(1)
    void start(){
        playerPlugin.start(mockedGameData,mockedWorld);

        verify(mockedWorld).addEntity(any(Player.class));
    }

    @Test
    @Order(2)
    void stop(){
        playerPlugin.stop(mockedGameData,mockedWorld);

        verify(mockedWorld).removeEntity(any(Player.class));
    }
}
