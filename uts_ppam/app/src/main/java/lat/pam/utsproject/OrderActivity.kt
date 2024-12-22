package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodSelected = intent.getStringExtra("food_name")
        val foodNameTextView = findViewById<TextView>(R.id.etFoodName)

        foodNameTextView.text = foodSelected ?: "No food selected"
        val servingsEditText = findViewById<EditText>(R.id.etServings)
        val orderingNameEditText = findViewById<EditText>(R.id.etName)
        val notesEditText = findViewById<EditText>(R.id.etNotes)
        val buttonPlaceOrder = findViewById<Button>(R.id.btnOrder)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonPlaceOrder.setOnClickListener {
            val servings = servingsEditText.text.toString().trim()
            val orderingName = orderingNameEditText.text.toString().trim()
            val additionalNotes = notesEditText.text.toString().trim()

            if (servings.isEmpty() || orderingName.isEmpty() || additionalNotes.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please fill out all fields before placing your order.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent = Intent(this, ConfirmationActivity::class.java)

                intent.putExtra("food_name", foodSelected)
                intent.putExtra("servings", servings)
                intent.putExtra("ordering_name", orderingName)
                intent.putExtra("additional_notes", additionalNotes)

                startActivity(intent)
            }
        }
    }
}