import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;
import dk.sdu.raeri21.cbse.common.services.IPostEntityProcessingService;

module Common {
    exports dk.sdu.raeri21.cbse.common.services;
    exports dk.sdu.raeri21.cbse.common.data.entityparts;
    exports dk.sdu.raeri21.cbse.common.data;

    uses IGamePluginService;
    uses IPostEntityProcessingService;
    uses IEntityProcessingService;
}