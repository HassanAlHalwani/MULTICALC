package com.example.dialogfragment

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.power
import kotlin.math.pow

class CustomDialogClass2 : DialogFragment(R.layout.fragment_blank2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelbt : Button = view.findViewById(R.id.cancelBT)
        val submitbt : Button= view.findViewById(R.id.submitBT)
        val radioGroup= view.findViewById<RadioGroup>(R.id.RatingRadioGroup)
        cancelbt.setOnClickListener {
            dismiss()
        }
        submitbt.setOnClickListener {
            val selectedOption : Int = radioGroup.checkedRadioButtonId
            val radioButton= view.findViewById<RadioButton>(selectedOption)
            val m1: MainActivity =getActivity() as MainActivity
            m1.receiveFeedback(radioButton.text.toString())

            dismiss()
        }
    }
}