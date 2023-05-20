package dk.sdu.raeri21.cbse.playersystem;

import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlayerPluginTest {

    @Mock
    private static GameData mockedGameData;
    @Mock
    private static World mockedWorld;
    private static PlayerPlugin playerPlugin;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);

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
