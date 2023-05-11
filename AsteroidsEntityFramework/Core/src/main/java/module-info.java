module Core {
    requires Common;
    requires CommonBullet;
    requires CommonAsteroid;
    requires java.desktop;
    requires com.badlogic.gdx;
    uses dk.sdu.raeri21.cbse.common.services.IGamePluginService;
    uses dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.raeri21.cbse.common.services.IPostEntityProcessingService;
}


