package com.example.testdaggger

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
@Inject
lateinit var factory:ViewModelProvider.Factory

    lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
val textView=findViewById<TextView>(R.id.tv)
       // DaggerMYComponent.create().inject(this)
       // DaggerMYComponent.factory().create(this)
myViewModel=ViewModelProviders.of(this,factory).get(MyViewModel::class.java)
myViewModel.mutableContactList.observe(this,{
    textView.text = it
})
    }

}
