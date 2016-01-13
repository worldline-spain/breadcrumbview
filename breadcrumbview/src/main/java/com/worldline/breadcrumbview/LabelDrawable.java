package com.worldline.breadcrumbview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Created by a511218 on 11/01/2016.
 */
public class LabelDrawable extends Drawable {


    public enum Sides {OPEN, CLOSED};

    private Paint paint;
    private Path path;
    private Sides start=Sides.CLOSED;
    private Sides end=Sides.OPEN;
    private int color;



    public LabelDrawable() {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        path=new Path();
        ;

    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawPath(path, paint);
    }


    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }

    private void updatePath(Rect bounds) {
        int h=bounds.bottom-bounds.top;
        paint.setColor(color);

        path.reset();

        path.moveTo(bounds.left, bounds.top);

        if (end==Sides.OPEN) {
            path.lineTo(bounds.right - h / 2, 0);
            path.lineTo(bounds.right, bounds.top + h / 2);
            path.lineTo(bounds.right - h / 2, bounds.bottom);
        }else{
            path.lineTo(bounds.right,bounds.top);
            path.lineTo(bounds.right, bounds.bottom);
        }
        path.lineTo(bounds.left,bounds.bottom);
        if (start==Sides.OPEN) {
            path.lineTo(bounds.left + h/2, bounds.top+h/2);
        }
        path.close();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        updatePath(bounds);
    }

    public Sides getStart() {
        return start;
    }

    public void setStart(Sides start) {
        this.start = start;
        this.invalidateSelf();

    }

    public Sides getEnd() {
        return end;
    }

    public void setEnd(Sides end) {
        this.end = end;
        this.invalidateSelf();
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidateSelf();
    }
}
