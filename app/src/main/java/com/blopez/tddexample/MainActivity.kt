package com.blopez.tddexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.blopez.tddexample.model.Orientation
import com.blopez.tddexample.model.Rover
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var rover = Rover()
            rover.applyCommand(editText.text.toString())
            if(rover.direction.equals(Orientation.EAST)){
                textView2.text = "OKKKK"
            }
        }

    }
}
