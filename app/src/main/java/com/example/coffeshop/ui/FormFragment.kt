package com.example.coffeshop.ui

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.coffeshop.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {
    lateinit var  name: EditText
    lateinit var  email: EditText
    lateinit var  phone: EditText
    lateinit var  male : RadioButton
    lateinit var  female:RadioButton
    lateinit var  submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_form, container, false)
        name=v.findViewById(R.id.name)
        email=v.findViewById(R.id.email)
        phone=v.findViewById(R.id.phone)
        male=v.findViewById(R.id.male)
        female=v.findViewById(R.id.female)
        submit=v.findViewById(R.id.submit)

        return  v;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit.setOnClickListener {
            if(validate())
            {
               showMessage("Thanks \nYour form has been submitted");
            }
        }

        male.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->

           if(b)
           {
               female.isChecked=false
           }


        })

        female.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->

            if(b)
            {
                male.isChecked=false
            }


        })
    }

    fun validate():Boolean
    {
        if(name.text.toString().isEmpty())
        {
            showToast("Please enter your name")
            return  false;
        }

        if(phone.text.toString().isEmpty())
        {
            showToast("Please enter your phone")
            return  false;
        }


        if(email.text.toString().isEmpty())
        {
            showToast("Please enter your email")
            return  false;
        }

        if(!male.isChecked && !female.isChecked)
        {
            showToast("Please select gender")
            return  false;
        }

        return  true
    }

    fun showToast(msg:String)
    {
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
    }

    private fun showMessage(message: String) {
        AlertDialog.Builder(activity as Context)
            .setMessage(message)
            .setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->  })

            .create()
            .show()
    }

}