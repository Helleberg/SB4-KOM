package dk.sdu.raeri21.cbse.components;

import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;

public interface IProcessor {
    void process(GameData gameData, World world);
}
