package dev.tal.engine;

import java.util.ArrayList;
import java.util.List;

import dev.tal.engine.living.LivingEntity;
import dev.tal.engine.living.impl.Follower;
import dev.tal.engine.living.impl.Player;

public class Engine {
	
	public static int width = 600, height = 600;
	private static List<LivingEntity> entities = new ArrayList<LivingEntity>();
	public static Window window;
	public static GamePanel panel;
	
	public static void main(String[] args) {
		setup();
		panel = new GamePanel();
		window = new Window(panel, width, height);
		panel.requestFocus();
		window.run();
	}

	public static void setup() {
		entities.add(new Player());
		entities.add(new Follower());
	}
	
	public static List<LivingEntity> getEntities() {
		return entities;
	}
}
