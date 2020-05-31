package com.pdamian.testlab10;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;

public class Kulki extends View
{
int xA = 60;
int yA = 60;
int xB = 120;
int yB = 120;
Context context;
int szerokosc=900;
int p=0;

    public Kulki(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        new myAsyncTask().execute();
    }

   
    private class myAsyncTask extends AsyncTask<String, String, String>
    {

       
        @Override
        protected void onProgressUpdate(String... values)
        {
            super.onProgressUpdate(values);
            p = Integer.parseInt(values[0]);
            invalidate();
        }

       
        @Override
        protected String doInBackground(String... strings)
        {
            int d = 0;
            while (d >= -5)
            {
                for (int i = 0; i < szerokosc; i = i + 20)
                {
                    
                    publishProgress(Integer.toString(i));
                 
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                for (int i = szerokosc; i >= 0; i = i - 20)
                {
                    
                    publishProgress(Integer.toString(i));
                  
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            return "";
        }
    }
   
    protected void onDraw(Canvas canvas)
    {
        
        int iloscKul=Integer.parseInt(MainActivity.pilosc);
        String setKolor= MainActivity.pkolor;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(setKolor));
    
        RectF rect1 = new RectF(xA+p,yA,xB+p,yB);
        RectF rect2 = new RectF(xA+p,yA+100,xB+p,yB+100);
        RectF rect3 = new RectF(xA+p,yA+200,xB+p,yB+200);
        RectF rect4 = new RectF(xA+p,yA+300,xB+p,yB+300);
        RectF rect5 = new RectF(xA+p,yA+400,xB+p,yB+400);
        RectF rect6 = new RectF(xA+p,yA+500,xB+p,yB+500);

       
        switch (iloscKul)
        {
            case 1:
                canvas.drawOval(rect1,paint);
                break;
            case 2:
                canvas.drawOval(rect1,paint);
                canvas.drawOval(rect2,paint);
                break;
            case 3:
                canvas.drawOval(rect1,paint);
                canvas.drawOval(rect2,paint);
                canvas.drawOval(rect3,paint);
                break;
            case 4:
                canvas.drawOval(rect1,paint);
                canvas.drawOval(rect2,paint);
                canvas.drawOval(rect3,paint);
                canvas.drawOval(rect4,paint);
                break;
            case 5:
                canvas.drawOval(rect1,paint);
                canvas.drawOval(rect2,paint);
                canvas.drawOval(rect3,paint);
                canvas.drawOval(rect4,paint);
                canvas.drawOval(rect5,paint);
                break;
            case 6:
                canvas.drawOval(rect1,paint);
                canvas.drawOval(rect2,paint);
                canvas.drawOval(rect3,paint);
                canvas.drawOval(rect4,paint);
                canvas.drawOval(rect5,paint);
                canvas.drawOval(rect6,paint);
                break;
        }
    }
}
