import dk.sdu.raeri21.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    provides IPostEntityProcessingService with dk.sdu.raeri21.cbse.collisionsystem.CollisionDetection;
}