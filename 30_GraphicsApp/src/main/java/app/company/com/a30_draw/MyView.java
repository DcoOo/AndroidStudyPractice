package app.company.com.a30_draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/9/8.
 */
public class MyView extends View {

    private Paint paint;
    private Canvas canvas;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        canvas.drawColor(Color.BLUE);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5);
        drawRect(100,100,200,200);
        draw();
        drawText();
    }

    public void drawRect(float left,float top,float right,float bottom){
        canvas.drawRect(left,top,right,bottom,paint);
    }

    public void draw(){
        Path path = new Path();
        path.moveTo(500,0);
        path.lineTo(1000,0);
        path.lineTo(1200,1000);
        path.close();
        canvas.drawPath(path,paint);
    }

    public void drawText(){
        paint.setTextSize(80);
        Path path = new Path();
        path.moveTo(300,50);
        paint.setStrikeThruText(true);
        Path text_path = new Path();
        text_path.addCircle(200,300,80,Path.Direction.CCW);
        canvas.drawTextOnPath("Hello World",text_path,0,10,paint);
    }
}
