package dk.sdu.raeri21.cbse.asteroidsystem;

import dk.sdu.raeri21.cbse.common.asteroid.Asteroid;
import dk.sdu.raeri21.cbse.common.asteroid.IAsteroidSplitter;
import dk.sdu.raeri21.cbse.common.data.Entity;
import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.common.data.entityparts.LifePart;
import dk.sdu.raeri21.cbse.common.data.entityparts.MovingPart;
import dk.sdu.raeri21.cbse.common.data.entityparts.PositionPart;
import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;

public class AsteroidProcess implements IEntityProcessingService {

    private IAsteroidSplitter asteroidSplitter = new AsteroidSplitterImpl();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);

            int numPoints = 12;
            float speed = (float) Math.random() * 10f + 20f;
            if (lifePart.getLife() == 1) {
                numPoints = 8;
                speed = (float) Math.random() * 30f + 70f;
            } else if (lifePart.getLife() == 2) {
                numPoints = 10;
                speed = (float) Math.random() * 10f + 50f;
            }
            movingPart.setSpeed(speed);
            movingPart.setUp(true);

            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            // Split event
            if (lifePart.isHit()) {
                this.asteroidSplitter.createSplitAsteroid(asteroid, world);
            }

            setShape(asteroid, numPoints);
        }
    }

    private void setShape(Entity entity, int numPoints) {
        PositionPart position = entity.getPart(PositionPart.class);
        float[] shapex = new float[numPoints];
        float[] shapey = new float[numPoints];
        float radians = position.getRadians();
        float x = position.getX();
        float y = position.getY();
        float radius = entity.getRadius();

        float angle = 0;

        for (int i = 0; i < numPoints; i++) {
            shapex[i] = x + (float) Math.cos(angle + radians) * radius;
            shapey[i] = y + (float) Math.sin(angle + radians) * radius;
            angle += 2 * 3.1415f / numPoints;
        }

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
