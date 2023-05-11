package dk.sdu.raeri21.cbse.common.bullet;

import dk.sdu.raeri21.cbse.common.data.Entity;
import dk.sdu.raeri21.cbse.common.data.GameData;

public interface BulletSPI {
    Entity createBullet(Entity e, GameData gameData);
}
