package lat.pam.droidcafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import lat.pam.droidcafe.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private var orderData: String = ""
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageView>(R.id.donut)
            .setOnClickListener(View.OnClickListener {
                displayToast(resources.getString(R.string.donut_order_message))
                orderData = "Donut"
                (activity as MainActivity).setOrderData(orderData)
            })

        view.findViewById<ImageView>(R.id.ice_cream)
            .setOnClickListener(View.OnClickListener {
                displayToast(getString(R.string.ice_cream_order_message))
                orderData = "Ice Cream"
                (activity as MainActivity).setOrderData(orderData)
            })

        view.findViewById<ImageView>(R.id.froyo)
            .setOnClickListener(View.OnClickListener {
                displayToast(getString(R.string.froyo_order_message))
                orderData = "Froyo"
                (activity as MainActivity).setOrderData(orderData)
            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun displayToast(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}