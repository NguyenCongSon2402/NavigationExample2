package com.example.navigationexample.network.model

import com.google.gson.annotations.SerializedName


data class Home (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : Data?   = Data()

)