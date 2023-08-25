package dev.tal.engine.living.impl;

import java.awt.event.KeyEvent;

import dev.tal.engine.living.Direction;
import dev.tal.engine.living.LivingEntity;
import dev.tal.engine.living.LivingInfo;

@LivingInfo(renderable = "player.png", width = 75, height = 75)
public class Player extends LivingEntity {

	public Direction movement;
	public boolean isMoving = false;
	public final int boost = 4;
	public int currentKey = 0;
	
	public Player() {}
	
	public void update() {
		if(isMoving && movement != null) {
			this.addForce(movement, boost);
		}
	}
	
	public void keyPressed(int key) {
		currentKey = key;
		switch(key) {
			case KeyEvent.VK_W:
				movement = Direction.UP;
				isMoving = true;
				break;
			case KeyEvent.VK_S:
				movement = Direction.DOWN;
				isMoving = true;
				break;
			case KeyEvent.VK_A:
				movement = Direction.LEFT;
				isMoving = true;
				break;
			case KeyEvent.VK_D:
				movement = Direction.RIGHT;
				isMoving = true;
				break;
		}
	}
	
	public void keyReleased(int key) {
		if(isMoving && currentKey == key) {
			isMoving = false;
		}
	}
	
}
