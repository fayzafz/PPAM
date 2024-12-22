package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Cireng", "Cireng alias Aci digoreng yang enak disantap ketika panas", R.drawable.cireng),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Donut", "Donut ini rasanya manis, kaya kamu:)", R.drawable.donut),
            Food("Kopi Hitam", "Kopi Hitam enak buat temenin Anda begadang", R.drawable.kopi_hitam ),
            Food("Nasi Goreng", "Nasi goreng dengan bumbu rempah asli", R.drawable.nasigoreng),
            Food("Teh Manis", "Teh manis dari pucuk teh pilihan", R.drawable.sparkling_tea),
            Food("Cheese Cake", "Cheese Cake yang terjangkau dan enak apabila di santap", R.drawable.cheesecake)
        )

        adapter = FoodAdapter(foodList) { food ->
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("food_name", food.name)
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}