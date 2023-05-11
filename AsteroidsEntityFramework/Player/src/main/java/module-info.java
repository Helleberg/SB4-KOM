import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;
import dk.sdu.raeri21.cbse.playersystem.PlayerProcess;

module Player {
    requires Common;
    requires CommonBullet;
    uses dk.sdu.raeri21.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with dk.sdu.raeri21.cbse.playersystem.PlayerPlugin;
    provides IEntityProcessingService with PlayerProcess;
}