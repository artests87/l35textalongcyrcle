package com.example.artests.l35textalongcyrcle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by artests on 25.01.2016.
 */
public class CurvedTextView extends View {

    private Path mPath;
    private Paint mPaint;

    public CurvedTextView(Context context) {
        super(context);
        mPath = new Path();
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Установим градиент для фона формы
        setBackgroundResource(R.drawable.background);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(3);
        mPaint.setAntiAlias(true);

        mPath.moveTo(20, 25);
        mPath.cubicTo(500, 100, 100, 500, 800, 380); //107

        canvas.drawPath(mPath, mPaint);

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setTextSize(50);

        mPaint.setColor(Color.GRAY);
        canvas.drawTextOnPath("Вот кто-то с горочки спустился", mPath, 102,
                -4, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawTextOnPath("Вот кто-то с горочки спустился", mPath, 100,
                -2, mPaint);
    }
}
