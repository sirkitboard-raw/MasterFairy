package com.Amp.masterfairy;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {
	int prevx, prevy;
	// public int[] colors = new int[4];
	int[] enteredColors = new int[4];
	DrawView v;
	int counter = 0;
	int tcounter = 0;

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		int x = (int) e.getX();
		int y = (int) e.getY();
		if (tcounter < 11) {
			if (x != prevx && x != prevy) {
				if (counter < 4) {
					for (int i = 0; i < 8; i++) {
						Circle c = v.cir[i];
						float dist = (float) Math.sqrt(Math.pow(e.getX()
								- v.colorPal[i].centerX, 2)
								+ Math.pow(e.getY() - 220
										- v.colorPal[i].centerY, 2));
						if (v.colorPal[i].radius >= (int) dist) {
							v.cirArr[10 - tcounter][counter].color = v.colorPal[i].color;
							v.cirArr[10 - tcounter][counter++].order = v.colorPal[i].order;
							break;
						}
					}
				} 
				else {
					counter = 0;
					tcounter++;
					v.result = "";
					for (int i = 0; i < 4; i++) {
						v.colors[i] = 0;
					}
					v.result = "temp";
					int corColor = 0;
					int corPos = 0;
					for (int i = 0; i < 4; i++) {
						for (int j = 0; j < 4; j++) {
							if (v.cirArr[11 - tcounter][i].color == v.cirArr[0][j].color) {
								if (i == j) {
									corPos++;
								} else
									corColor++;
							}
						}
					}
					v.result = corColor + ", " + corPos;
					if (corPos == 4) {
						v.result = "You WIN!";
					} 
					else if (corColor == 0 && corPos == 0) {
						v.result = "No matches";
					} 
					else if (tcounter == 11) {
						v.result = "YOU LOSE";
					}
				}
			}
		}
		prevx = x;
		prevy = y;
		return false;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		v = new DrawView(this);
		for (int i = 0; i < 4; i++) {
			v.colors2[i] = (int) (Math.random() * 8);
		}
		v.colorOrder[0] = Color.BLUE;
		v.colorOrder[1] = Color.RED;
		v.colorOrder[2] = Color.CYAN;
		v.colorOrder[3] = Color.GREEN;
		v.colorOrder[4] = Color.MAGENTA;
		v.colorOrder[5] = Color.YELLOW;
		v.colorOrder[6] = Color.WHITE;
		v.colorOrder[7] = Color.LTGRAY;
		v.colorPal[0] = new Circle(969f, 170f, 70f, Color.BLUE, 0, true);
		v.colorPal[1] = new Circle(969f, 330f, 70f, Color.RED, 1, true);
		v.colorPal[2] = new Circle(969f, 490f, 70f, Color.CYAN, 2, true);
		v.colorPal[3] = new Circle(969f, 650f, 70f, Color.GREEN, 3, true);
		v.colorPal[4] = new Circle(969f, 810f, 70f, Color.MAGENTA, 4, true);
		v.colorPal[5] = new Circle(969f, 970f, 70f, Color.YELLOW, 5, true);
		v.colorPal[6] = new Circle(969f, 1130f, 70f, Color.WHITE, 6, true);
		v.colorPal[7] = new Circle(969f, 1290f, 70f, Color.LTGRAY, 7, true);
		for (int i = 0; i < v.cirArr.length; i++) {
			for (int j = 0; j < v.cirArr[0].length; j++) {
				v.cirArr[i][j] = new Circle((float) (100 + j * 150 + 75),
						(float) (100 + i * 120 + 60), 50f, Color.WHITE, 0,
						false);
			}
		}
		for (int i = 0; i < v.cirArr[i].length; i++) {
			v.cirArr[0][i].color = v.colorOrder[v.colors2[i]];
		}
        this.
		setContentView(v);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
