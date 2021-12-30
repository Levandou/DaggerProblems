package com.example.testdaggger

import android.content.ContentResolver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(private val repository: Repository): ViewModel() {
     val mutableContactList = MutableLiveData<String>()

    fun getDataViewModel(){
        mutableContactList.value= repository.getData()
    }
    init {
        getDataViewModel()
    }

}


class Repository @Inject constructor(/* val contentResolver:ContentResolver */){
    fun getData():String{
        val contentResolver: String="asd"
        return contentResolver.toString()
    }
}

class MyViewModelFactory @Inject constructor(private val myViewModelProvider: Provider<MyViewModel>):ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return myViewModelProvider.get() as T
    }

}
