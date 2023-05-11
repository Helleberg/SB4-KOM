package dk.sdu.raeri21.cbse.playersystem;

import dk.sdu.raeri21.cbse.common.bullet.BulletSPI;
import dk.sdu.raeri21.cbse.common.data.Entity;
import dk.sdu.raeri21.cbse.common.data.GameData;

import dk.sdu.raeri21.cbse.common.data.GameKeys;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.common.data.entityparts.LifePart;
import dk.sdu.raeri21.cbse.common.data.entityparts.MovingPart;
import dk.sdu.raeri21.cbse.common.data.entityparts.PositionPart;
import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

/**
 *
 * @author jcs
 */
public class PlayerProcess implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);
            LifePart lifePart = player.getPart(LifePart.class);

            movingPart.setLeft(gameData.getKeys().isDown(GameKeys.LEFT));
            movingPart.setRight(gameData.getKeys().isDown(GameKeys.RIGHT));
            movingPart.setUp(gameData.getKeys().isDown(GameKeys.UP));

            if (gameData.getKeys().isDown(GameKeys.SPACE)) {
                for (BulletSPI bullet : getBulletSPIs()) {
                    world.addEntity(bullet.createBullet(player, gameData));
                }
            }
            
            movingPart.process(gameData, player);
            positionPart.process(gameData, player);
            lifePart.process(gameData, player);

            updateShape(player);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
