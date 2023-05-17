package dk.sdu.raeri21.cbse.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		int width = 1400;
		int height = 800;

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("raeri21 - Asteroids");
		config.setWindowedMode(width, height);
		config.setWindowSizeLimits(width,height,width,height);
		config.setResizable(false);

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.scan("dk.sdu.raeri21.cbse.main");
		applicationContext.refresh();

		new Lwjgl3Application((ApplicationListener) applicationContext.getBean("game"), config);
		
	}
	
}
