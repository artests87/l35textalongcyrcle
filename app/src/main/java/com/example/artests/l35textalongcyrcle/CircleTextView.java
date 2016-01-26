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
public class CircleTextView extends View {
    private Paint mPaint;
    private Paint mTextPaint;
    private Path mCirclePath;

    public CircleTextView(Context context) {
        super(context);
        mPaint = new Paint();
        mTextPaint = new Paint();
        mCirclePath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // Установим градиент для фона
        setBackgroundResource(R.drawable.background);

        // Настраиваем окружность
        mPaint.setColor(Color.BLUE); // цвет окружности
        mPaint.setStyle(Paint.Style.STROKE); // делаем окантовку вместо круга
        mPaint.setStrokeWidth(2.0f); // толщина окантовки
        mPaint.setAntiAlias(true); // сглаживание

        // Работаем с текстом
        mTextPaint.setTextSize(36); // размер текста 1
        mTextPaint.setAntiAlias(true); // сглаживание
        mTextPaint.setColor(Color.WHITE); // цвет текста

        // Добавляем окружность
        mCirclePath.addCircle(240, 240, 115, Path.Direction.CW);

        // Выводим контур окружности на экран
        canvas.drawPath(mCirclePath, mPaint);
        // Выводим текст на экран вдоль окружности
        canvas.drawTextOnPath("Коты и кошки всех стран, соединяйтесь! * ",
                mCirclePath, 0, 32, mTextPaint);

        // Для API 11 и выше
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
}
