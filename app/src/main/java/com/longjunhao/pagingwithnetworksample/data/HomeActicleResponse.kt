package com.longjunhao.pagingwithnetworksample.data

import com.google.gson.annotations.SerializedName

/**
 * .HomeActicleResponse
 *
 * @author Admitor
 * @date 2020/09/23
 */
data class HomeActicleResponse(
    @field:SerializedName("data") val datas: HomeActiclePage,
    @field:SerializedName("errorCode") val errorCode: Int,
    @field:SerializedName("errorMsg") val errorMsg: String,
)