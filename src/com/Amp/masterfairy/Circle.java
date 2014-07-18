package com.Amp.masterfairy;

import android.graphics.Color;

public class Circle {
	public float centerX;
	public float centerY;
	public float radius;
	public int color;
	public int order;
	public boolean visible = false;
	public Circle(float centerX, float centerY, float radius, int color,
			int order, boolean visible) {
		super();
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.color = color;
		this.order = order;
		this.visible = visible;
	}
	
}
