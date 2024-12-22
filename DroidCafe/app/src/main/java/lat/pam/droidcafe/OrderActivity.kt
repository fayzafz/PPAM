package lat.pam.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class OrderActivity : AppCompatActivity() {

    private var isSpinnerInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val orderData = intent.getStringExtra("ORDER_DATA")

        val orderDataTextView = findViewById<TextView>(R.id.orderDataTextView)

        if (orderData != "") {
            orderDataTextView.text = "Anda Mengorder : $orderData"
        } else {
            orderDataTextView.text = "Tidak Ada Barang yang di order"
        }

        val kota = resources.getStringArray(R.array.city)
        val spinner = findViewById<Spinner>(R.id.spinner)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, kota
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    if (isSpinnerInitialized) {
                        val selectedCity = kota[position]
                        if (selectedCity != "Pilih Kota :") {
                            Toast.makeText(
                                this@OrderActivity,
                                getString(R.string.selected_item) + " " +
                                        "" + kota[position], Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        isSpinnerInitialized = true
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Does nothing when no items are selected
                }
            }
        }

    }

    fun onRadioButtonClicked(view: View) {

        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            R.id.sameday -> if (checked) // Same day service
                displayToast(getString(R.string.same_day_messenger_service))

            R.id.nextday -> if (checked) // Next day delivery
                displayToast(getString(R.string.next_day_ground_delivery))

            R.id.pickup -> if (checked) // Pick up
                displayToast(getString(R.string.pick_up))

            else -> {}
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext, message, Toast.LENGTH_SHORT
        ).show()
    }

}