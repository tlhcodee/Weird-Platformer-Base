package dev.tal.engine.living.impl;

import dev.tal.engine.Engine;
import dev.tal.engine.living.LivingEntity;
import dev.tal.engine.living.LivingInfo;

@LivingInfo(renderable = "player2.png", width = 75, height = 75)
public class Follower extends LivingEntity{
	
	public LivingEntity target;
	
	public void update() {
		target = getTarget();
		if(target != null) {
			this.follow(target, 2);
		}
	}
	
	public LivingEntity getTarget() {
		for(LivingEntity entities : Engine.getEntities()) {
			if(entities.getRenderable().equals("player.png")) {
				return entities;
			}
		}
		return null;
	}
}
