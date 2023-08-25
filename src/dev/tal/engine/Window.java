package dev.tal.engine;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import dev.tal.engine.living.LivingEntity;

@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable{
	
	private final float FPS = 60;
	public long lastFrame = 0;
	
	public Window(GamePanel panel, int width, int height) {
		setTitle("Deneme");
		setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));
        setMinimumSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        add(panel);
		setVisible(true);
	}

	@Override
	public void run() {
		double timePF = 1000000000.0 / FPS;
		lastFrame = System.nanoTime();
		long now = System.nanoTime();
		while(true) {
			now = System.nanoTime();
			if(now - lastFrame >= timePF) {
				for(LivingEntity entity : Engine.getEntities()) {
					entity.update();
				}
				lastFrame = now;
			}
		}
		
	}

}
