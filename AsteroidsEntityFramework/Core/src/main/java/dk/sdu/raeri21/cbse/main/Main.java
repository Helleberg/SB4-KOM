package dk.sdu.raeri21.cbse.main;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
	
	public static void main(String[] args) {
		int width = 500;
		int height = 400;

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("raeri21 - Asteroids");
		config.setWindowedMode(width, height);
		config.setWindowSizeLimits(width,height,width,height);
		config.setResizable(false);

		new Lwjgl3Application(new Game(), config);
		
	}
	
}
