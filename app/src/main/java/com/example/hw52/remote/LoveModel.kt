package com.example.hw52.remote

import android.os.Parcelable
data class LoveModel (
    var fname: String,
    var sname: String,
    var percentage: String,
    var result: String,
) : java.io.Serializable