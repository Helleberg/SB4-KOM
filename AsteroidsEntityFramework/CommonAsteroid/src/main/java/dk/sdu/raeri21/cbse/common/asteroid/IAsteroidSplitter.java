package dk.sdu.raeri21.cbse.common.asteroid;

import dk.sdu.raeri21.cbse.common.data.Entity;
import dk.sdu.raeri21.cbse.common.data.World;

public interface IAsteroidSplitter {
    void createSplitAsteroid(Entity e, World world);
}
