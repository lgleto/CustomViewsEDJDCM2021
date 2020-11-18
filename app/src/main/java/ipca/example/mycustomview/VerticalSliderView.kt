package ipca.example.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi

//
// Created by lourencogomes on 11/11/2020.
//
class VerticalSliderView : View {

    var touchY = 0.0f

    constructor(context: Context?) : super(context)
    {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        init()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes){
        init()
    }

    fun init(){

    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10.0f
        val rectF = RectF(0.0f, 0.0f, width.toFloat(), height.toFloat() )
        canvas?.drawRoundRect(rectF, 20.0f, 20.0f, paint)

        val paintIn = Paint()
        paintIn.color = Color.YELLOW
        paintIn.style = Paint.Style.FILL_AND_STROKE

        val rectFIn = RectF(10.0f, touchY-10.0F, width.toFloat()-10.0f, height.toFloat()-10.0f )
        canvas?.drawRoundRect(rectFIn, 20.0f, 20.0f, paintIn)


    }

    public var setOnValueChange :((value:Float)->Unit)? = null

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val y = event?.y

        when(event?.action){
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_MOVE -> {
                touchY = y?:0f
                setOnValueChange
                invalidate()
                var percent : Float = (100 - touchY/height*100.0f)
                if (percent > 100) percent = 100f
                if (percent < 0) percent = 0f
                setOnValueChange?.invoke(percent)
            }
        }




        return true
    }


}