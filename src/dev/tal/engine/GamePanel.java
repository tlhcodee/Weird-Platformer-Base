package dev.tal.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import dev.tal.engine.living.LivingEntity;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	public GamePanel() {
        addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				for(LivingEntity entity : Engine.getEntities()) {
					entity.keyPressed(e.getKeyCode());
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				for(LivingEntity entity : Engine.getEntities()) {
					entity.keyReleased(e.getKeyCode());
				}
			}
        	
        });
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(LivingEntity entity : Engine.getEntities()) {
			g.drawImage(entity.getLabel(),
					entity.getX(),
					entity.getY(),
					entity.getWidth(),
					entity.getHeight(),
					this);
		}
		g.setColor(Color.RED);
		g.drawString("Just a weird base for platformer", 15, 15);
		g.setColor(Color.BLUE);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		g.drawString("Java is the best man", 15, 30);
		this.repaint();
	}

}
