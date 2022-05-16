package com.example.coffeshop.ui

import android.graphics.drawable.Drawable

class Coffee {
    lateinit var  coffeeInfo:String
      var  coffeeImage:Drawable?

    constructor(coffeeInfo: String, coffeeImage: Drawable?) {
        this.coffeeInfo = coffeeInfo
        this.coffeeImage = coffeeImage
    }
}