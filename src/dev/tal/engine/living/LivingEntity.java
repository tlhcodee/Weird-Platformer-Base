package dev.tal.engine.living;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dev.tal.engine.Engine;

public class LivingEntity {
	
	private final LivingInfo info = this.getClass().getAnnotation(LivingInfo.class);
	private String renderable = info.renderable();
	private BufferedImage label;
	private int x, y, width = info.width(), height = info.height();
	
	public LivingEntity() {
        try {
            File path = new File(renderable);
            label = ImageIO.read(path);
          } catch (IOException ex) {
              ex.printStackTrace();
        }
		x = (Engine.width / 2) - this.width;
		y = (Engine.height / 2) - this.height;
	}
	
	public void start() {}
	public void update() {}
	
	public void keyPressed(int key) {}
	public void keyReleased(int key) {}
	
	public void addForce(Direction movement, int boost) {
		boolean left = movement == Direction.LEFT;
		boolean right = movement == Direction.RIGHT;
		boolean up = movement == Direction.UP;
		boolean down = movement == Direction.DOWN;
		
		if(left) {
			this.x -= boost;
		} else if(right) {
			this.x += boost;
		} else if(up) {
			this.y -= boost;
		} else if(down) {
			this.y += boost;
		}
	}
	
	public void follow(LivingEntity target, int boost) {
		if(target.getX() > this.getX()) {
			this.setX(this.getX() + boost);
		} else if(target.getX() < this.getX()) {
			this.setX(this.getX() - boost);
		}
		
		if(target.getY() > this.getY()) {
			this.setY(this.getY() + boost);
		} else if(target.getY() < this.getY()) {
			this.setY(this.getY() - boost);
		}
	}

	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public String getRenderable() {
		return renderable;
	}

	public void setRenderable(String renderable) {
		this.renderable = renderable;
	}

	public BufferedImage getLabel() {
		return label;
	}

	public void setLabel(BufferedImage label) {
		this.label = label;
	}

	public LivingInfo getInfo() {
		return info;
	}
	
	
	

}
