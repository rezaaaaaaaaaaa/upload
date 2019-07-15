package com.demo.demo.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.demo.R
import com.demo.demo.RecyclerView.RecyclerView_Horizantal
import com.demo.demo.RecyclerView.RecyclerView_Vertical
import com.demo.demo.model.Model
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.InputStream








class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var myList: MutableList<Model> = mutableListOf<Model>()
        var list_vertical: MutableList<Model> = mutableListOf<Model>()

        for(i in 0 until createListFromFile().size){

               if (createListFromFile()[i].mealType!!.title =="Lunch & Dinner"){


//
//
                   myList!!.add(Model(createListFromFile()[i].title,createListFromFile()[i].subTitle,createListFromFile()[i].preparation
                   ,createListFromFile()[i].delivery,createListFromFile()[i].image,createListFromFile()[i].rate,createListFromFile()[i].price
                   ,createListFromFile()[i].mealType))


                   }else if (createListFromFile()[i].mealType!!.title !="Lunch & Dinner"){
                   list_vertical!!.add(Model(createListFromFile()[i].title,createListFromFile()[i].subTitle,createListFromFile()[i].preparation
                       ,createListFromFile()[i].delivery,createListFromFile()[i].image,createListFromFile()[i].rate,createListFromFile()[i].price
                       ,createListFromFile()[i].mealType))
               }











           }
        Log.e("dd", myList[1].title)

                   recycler_horizantal.hasFixedSize()
                   recycler_horizantal.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                   recycler_horizantal.adapter=RecyclerView_Horizantal(myList,this)

        recycler_vertical.hasFixedSize()
        recycler_vertical.layoutManager= LinearLayoutManager(this)
        recycler_vertical.adapter=RecyclerView_Vertical(list_vertical,this)





    }

     fun createListFromFile() : List<Model>{
        val gson = Gson()
        val json = assets.open("menu.json")
            .bufferedReader()
            .readText()

        return gson.fromJson<List<Model>>(json, object : TypeToken<ArrayList<Model>>() {}.type)
    }
}
