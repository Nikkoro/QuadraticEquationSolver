package com.example.quadraticequationsolver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quadraticequationsolver.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{ solved() }
    }

    private fun solved(){
        val sA = binding.editTextNumberSigned.text.toString()
        val a = sA.toDoubleOrNull()
        val sB = binding.editTextNumberSigned2.text.toString()
        val b = sB.toInt()
        val sC = binding.editTextNumberSigned3.text.toString()
        val c = sC.toInt()

        if ( a == null || a == 0.0){
            binding.textView.text = getString(R.string.error)
            return
        }
        else{
            val delta = ((b * b) - (4 * a * c))
            val d = sqrt(delta)

            if(delta < 0){
                binding.textView.text = getString(R.string.deltas0)
            }

            if(delta == 0.0){
                var x = -b/(2 * a)
                binding.textView.text = getString(R.string.deltaeq0, x)
            }
            if(delta >0){
                var x1 = ((-b)-d)/(2 * a)
                var x2 = ((-b) + d)/(2 * a)
                binding.textView.text = getString(R.string.deltab0x1, x1,x2)



            }
        }
    }
}
