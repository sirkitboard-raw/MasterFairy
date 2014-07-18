package com.Amp.masterfairy;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
	public int colorOrder[] = new int[8];
	public int[] colors2 = new int[4];
	public Circle[] cir = new Circle[8];
	public int height = 0;
	public int width = 0;
	public Circle[][] cirArr = new Circle[11][4];
	public Circle[] colorPal = new Circle[8];
	
	Context context;
	public int[] colors = new int[4];
	public String result = "";
	public DrawView(Context context) {
		super(context);
		this.context = context;
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		canvas.drawPaint(paint);
		paint.setTextSize(40);
		for(int i = 0;i<colorPal.length;i++) {
			paint.setColor(colorPal[i].color);
			canvas.drawCircle(colorPal[i].centerX, colorPal[i].centerY, colorPal[i].radius,paint );
		}
		for(int i = 0;i<cirArr.length;i++) {
			for(int j=0;j<cirArr[i].length;j++) {
				paint.setColor(cirArr[i][j].color);
				canvas.drawCircle(cirArr[i][j].centerX, cirArr[i][j].centerY, cirArr[i][j].radius,paint );
			}	
		}
//		canvas.drawText("Color 1 : " + colors[0], 300, 175, paint);
//		canvas.drawText("Color 2 : " + colors[1], 300, 375, paint);
//		canvas.drawText("Color 3 : " + colors[2], 300, 575, paint);
//		canvas.drawText("Color 4 : " + colors[3], 300, 775, paint);
		paint.setColor(Color.WHITE);
		canvas.drawText("Result : " + result, 300, 1500, paint);
	//	canvas.drawText(colors2[0] + " " + colors2[1] + " " + colors2[2] + " " + colors2[3], 300, 1200, paint);
//		canvas.drawRect(300, 1300, 400, 1400, paint);
		super.onDraw(canvas);
		invalidate();
	}
	public void drawCircle(Canvas canvas, Paint paint, int no) {
		int x,y;
		x = 600;
		if(no == 0) {
			y = 175;
		}
		else if(no == 1) {
			y = 375;
		}
		else if(no == 2) {
			y = 575;
		}
		else {
			y = 775;
		}
		canvas.drawCircle(x, y, 75, paint);
	}
}
