package dk.sdu.raeri21.cbse.components;

import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

@Service("pluginInjector")
public class PluginInjection {
    public void startPlugins(GameData gameData, World world) {
        List<IGamePluginService> plugins = ServiceLoader.load(IGamePluginService.class).stream().map(java.util.ServiceLoader.Provider::get).collect(toList());
        for (IGamePluginService plugin : plugins) {
            plugin.start(gameData, world);
        }
    }
}
