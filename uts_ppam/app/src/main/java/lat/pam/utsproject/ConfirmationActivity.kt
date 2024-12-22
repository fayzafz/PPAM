package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val buttonBack = findViewById<Button>(R.id.backtoMenu)

        val foodNameTextView = findViewById<TextView>(R.id.tvFoodName)
        val servingsTextView = findViewById<TextView>(R.id.tvServings)
        val orderingNameTextView = findViewById<TextView>(R.id.tvOrderingName)
        val notesTextView = findViewById<TextView>(R.id.tvNotes)

        val foodName = intent.getStringExtra("food_name")
        val servings = intent.getStringExtra("servings")
        val orderingName = intent.getStringExtra("ordering_name")
        val additionalNotes = intent.getStringExtra("additional_notes")

        foodNameTextView.text = "$foodName"
        servingsTextView.text = "$servings pax"
        orderingNameTextView.text = "$orderingName"
        notesTextView.text = "$additionalNotes"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonBack.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,ListFoodActivity::class.java )
            startActivity(intent)
        })
    }
}