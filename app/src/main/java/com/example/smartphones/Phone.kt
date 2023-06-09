package com.example.smartphones

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone(var image : Int,
            var name : String,
            var price : String,
            var oldPrice : String,
            var isFavourite: Boolean,
            var isInCart : Boolean) : Parcelable