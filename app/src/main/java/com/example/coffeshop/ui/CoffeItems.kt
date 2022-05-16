package com.example.coffeshop.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshop.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CoffeItems.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoffeItems : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
     var  rvCoffee: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var v= inflater.inflate(R.layout.fragment_coffe_items, container, false)
        rvCoffee=v.findViewById(R.id.coffeeItemsRv)

        return  v;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
    }
    fun initRecycler()
    {
        var list:ArrayList<Coffee> = ArrayList();
        list.add(Coffee("Coffee Latte\n Price $2",(activity as Context).getDrawable(R.drawable.coffe_latte)))
        list.add(Coffee("Cappuccino \n Price $2",(activity as Context).getDrawable(R.drawable.capp)))
        list.add(Coffee("Espresso \n Price $2",(activity as Context).getDrawable(R.drawable.espresso)))
        list.add(Coffee("Black Coffee\n Price $2",(activity as Context).getDrawable(R.drawable.black_coffe)))
        var adapter:CoffeListAdapter= CoffeListAdapter(list,activity as Context);
        rvCoffee?.adapter=adapter
        rvCoffee?.layoutManager=LinearLayoutManager(activity)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CoffeItems.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CoffeItems().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}