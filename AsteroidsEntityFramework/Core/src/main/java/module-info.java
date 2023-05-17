module Core {
    requires Common;
    requires java.desktop;
    requires com.badlogic.gdx;
    requires spring.context;

    uses dk.sdu.raeri21.cbse.common.services.IGamePluginService;
    uses dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.raeri21.cbse.common.services.IPostEntityProcessingService;

    exports dk.sdu.raeri21.cbse.components;
    exports dk.sdu.raeri21.cbse.main;
}


