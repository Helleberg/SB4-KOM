import dk.sdu.raeri21.cbse.common.bullet.BulletSPI;
import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with dk.sdu.raeri21.cbse.bulletsystem.BulletPlugin;
    provides BulletSPI with dk.sdu.raeri21.cbse.bulletsystem.BulletProcess;
    provides IEntityProcessingService with dk.sdu.raeri21.cbse.bulletsystem.BulletProcess;
}