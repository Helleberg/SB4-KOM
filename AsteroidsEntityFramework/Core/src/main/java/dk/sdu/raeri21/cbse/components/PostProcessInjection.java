package dk.sdu.raeri21.cbse.components;

import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.common.services.IGamePluginService;
import dk.sdu.raeri21.cbse.common.services.IPostEntityProcessingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

@Service("postProcessorInjector")
public class PostProcessInjection implements IProcessor {
    @Override
    public void process(GameData gameData, World world) {
        List<IPostEntityProcessingService> processors = ServiceLoader.load(IPostEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
        for (IPostEntityProcessingService process : processors) {
            process.process(gameData, world);
        }
    }
}
