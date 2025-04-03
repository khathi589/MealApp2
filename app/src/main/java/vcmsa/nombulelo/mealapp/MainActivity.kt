package vcmsa.nombulelo.mealapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //step 1 : access the elements
        //create all the value of the elements
        val edtEnterDayTime = findViewById<EditText>(R.id.edtText)
        val edtMealSuggestion = findViewById<EditText>(R.id.edtTextText2)
        var btnGenerate = findViewById<Button>(R.id.button)
        var btnReset = findViewById<Button>(R.id.button2)

        //step 2 : add the functionality
        // Set click listeners
        btnGenerate.setOnClickListener {
            val dayTime = edtEnterDayTime.text.toString().trim().lowercase()
            val mealSuggestion = edtMealSuggestion.text.toString()

            if (dayTime.isEmpty()) {
                edtEnterDayTime.error = "Please enter a day time"
            } else if (mealSuggestion.isEmpty()) {
                edtMealSuggestion.error = "Please enter a meal suggestion"
            } else {
                // Generate meal suggestion based on day time
                val suggestion = generateMealSuggestion(dayTime)
                edtMealSuggestion.setText(suggestion)

            }

        }
        btnReset.setOnClickListener {
            edtEnterDayTime.text.clear()
            edtMealSuggestion.setText("Meal Suggestion will appear here")
        }
    }

    private fun generateMealSuggestion(dayTime: String): String {
        return when (dayTime) {
            "morning" -> "Breakfast:Huevos rancheros"
            "mid morning" -> "Snack:Breakfast cassrole "
            "afternoon" -> "QuickBite:Macaroni and Cheese"
            "dinner" -> "dinner: Burgers "
            "after dinner" ->"Dessert:Chocolate Mouse"
            else -> "Invalid input. Please enter a valid day time."
        }
    }
}











