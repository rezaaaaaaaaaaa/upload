package com.demo.demo.model

import com.google.gson.annotations.SerializedName

class Model{

    @SerializedName("title")
    var title:String?=null

    constructor(
        title: String?,
        subTitle: String?,
        preparation: String?,
        delivery: String?,
        image: String?,
        rate: String?,
        price: String?,
        mealType: Mealtype?
    ) {
        this.title = title
        this.subTitle = subTitle
        this.preparation = preparation
        this.delivery = delivery
        this.image = image
        this.rate = rate
        this.price = price
        this.mealType = mealType
    }

    @SerializedName("subTitle")
    var subTitle:String?=null


    @SerializedName("preparation")
    var preparation:String?=null

    @SerializedName("delivery")
    var delivery:String?=null

    @SerializedName("image")
    var image:String?=null

    @SerializedName("rate")
    var rate:String?=null

    @SerializedName("price")
    var price:String?=null

    @SerializedName("mealType")
    var mealType:Mealtype?=null



}