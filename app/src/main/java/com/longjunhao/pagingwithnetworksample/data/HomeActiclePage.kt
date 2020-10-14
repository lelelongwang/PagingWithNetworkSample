package com.longjunhao.pagingwithnetworksample.data

import com.google.gson.annotations.SerializedName

/**
 * .HomeActicleItem
 *
 * @author Admitor
 * @date 2020/09/23
 */
data class HomeActiclePage(
    @field:SerializedName("curPage") val curPage: Int,
    @field:SerializedName("datas") val datas: List<HomeActicleItem>,
    @field:SerializedName("offset") val offset: Int,
    @field:SerializedName("pageCount") val pageCount: Int,
    @field:SerializedName("size") val size: Int,
    @field:SerializedName("total") val total: Int
)