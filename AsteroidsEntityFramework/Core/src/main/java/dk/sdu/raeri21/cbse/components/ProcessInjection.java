package dk.sdu.raeri21.cbse.components;

import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.common.services.IEntityProcessingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

@Service("processorInjector")
public class ProcessInjection implements IProcessor{
    @Override
    public void process(GameData gameData, World world) {
        List<IEntityProcessingService> processors = ServiceLoader.load(IEntityProcessingService.class).stream().map(ServiceLoader.Provider::get).collect(toList());
        for (IEntityProcessingService process : processors) {
            process.process(gameData, world);
        }
    }
}
