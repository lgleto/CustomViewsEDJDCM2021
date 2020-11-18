package ipca.example.mycustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val verticalSliderView = findViewById<VerticalSliderView>(R.id.verticalSliderView)
        val textViewValue = findViewById<TextView>(R.id.textViewValue)



        verticalSliderView.setOnValueChange =  {
            textViewValue.text = it.toString()
        }
    }
}