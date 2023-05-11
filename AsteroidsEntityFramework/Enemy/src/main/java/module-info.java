import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;
import dk.sdu.raeri21.cbse.enemysystem.EnemyProcess;
import dk.sdu.raeri21.cbse.enemysystem.EnemyPlugin;

module Enemy {
    requires Common;
    requires CommonBullet;
    uses dk.sdu.raeri21.cbse.common.bullet.BulletSPI;
    provides IEntityProcessingService with EnemyProcess;
    provides IGamePluginService with EnemyPlugin;
}