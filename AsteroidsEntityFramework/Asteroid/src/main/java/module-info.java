import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    requires CommonAsteroid;
    provides IGamePluginService with dk.sdu.raeri21.cbse.asteroidsystem.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.raeri21.cbse.asteroidsystem.AsteroidProcess;
}