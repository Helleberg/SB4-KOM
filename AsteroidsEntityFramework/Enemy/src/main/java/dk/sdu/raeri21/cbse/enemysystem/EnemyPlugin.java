package dk.sdu.raeri21.cbse.enemysystem;

import dk.sdu.raeri21.cbse.common.data.Entity;
import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.common.data.entityparts.LifePart;
import dk.sdu.raeri21.cbse.common.data.entityparts.MovingPart;
import dk.sdu.raeri21.cbse.common.data.entityparts.PositionPart;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {
    private Entity enemy;
    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 5;
        float acceleration = 50;
        float maxSpeed = 150;
        float rotationSpeed = 5;
        float x = (float) (gameData.getDisplayWidth() * Math.random());
        float y = (float) (gameData.getDisplayHeight() * Math.random());
        float radians = 3.1415f / 2;

        Entity enemyShip = new Enemy();
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(5));

        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }
}
