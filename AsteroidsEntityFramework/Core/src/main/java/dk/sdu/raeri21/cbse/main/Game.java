package dk.sdu.raeri21.cbse.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.raeri21.cbse.common.data.Entity;
import dk.sdu.raeri21.cbse.common.data.GameData;
import dk.sdu.raeri21.cbse.common.data.World;
import dk.sdu.raeri21.cbse.components.IProcessor;
import dk.sdu.raeri21.cbse.components.PluginInjection;
import dk.sdu.raeri21.cbse.managers.GameInputProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component("game")
public class Game
        implements ApplicationListener {

    private AnnotationConfigApplicationContext components;

    private static OrthographicCamera cam;
    private ShapeRenderer sr;

    private final GameData gameData = new GameData();
    private World world = new World();

    public Game() {
        this.components = new AnnotationConfigApplicationContext();
        this.components.scan("dk.sdu.raeri21.cbse.components");
        this.components.refresh();
    }

    @Override
    public void create() {
        sr = new ShapeRenderer();

        if (gameData.getDisplayWidth() != Gdx.graphics.getWidth() || gameData.getDisplayHeight() != Gdx.graphics.getHeight()) {
            this.updateCam(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }

        Gdx.input.setInputProcessor(
                new GameInputProcessor(gameData)
        );

        ((PluginInjection) components.getBean("pluginInjector")).startPlugins(gameData, world);
    }

    @Override
    public void render() {

        // clear screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameData.setDelta(Gdx.graphics.getDeltaTime());

        update();

        draw();

        gameData.getKeys().update();
    }

    private void updateCam(int width, int height) {
        gameData.setDisplayWidth(width);
        gameData.setDisplayHeight(height);

        cam = new OrthographicCamera(gameData.getDisplayWidth(), gameData.getDisplayHeight());
        cam.translate((float) gameData.getDisplayWidth() / 2, (float) gameData.getDisplayHeight() / 2);
        cam.update();
    }

    private void update() {
        // Update
        ((IProcessor) components.getBean("processorInjector")).process(gameData, world);
        ((IProcessor) components.getBean("postProcessorInjector")).process(gameData, world);
    }

    private void draw() {
        for (Entity entity : world.getEntities()) {

            sr.setColor(1, 1, 1, 1);

            sr.begin(ShapeRenderer.ShapeType.Line);

            float[] shapex = entity.getShapeX();
            float[] shapey = entity.getShapeY();

            for (int i = 0, j = shapex.length - 1;
                    i < shapex.length;
                    j = i++) {

                sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);
            }

            sr.end();
        }
    }

    @Override
    public void resize(int width, int height) {
        this.updateCam(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
