package dev.tal.engine.living;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LivingInfo {
	String renderable();
	int width();
	int height();
}
