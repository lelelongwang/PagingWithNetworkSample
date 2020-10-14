package com.longjunhao.pagingwithnetworksample.data

import com.google.gson.annotations.SerializedName

/**
 * .HomeActicleItem
 *
 * @author Admitor
 * @date 2020/09/23
 */
data class HomeActicleItem(
    @field:SerializedName("author") val author: String,
    @field:SerializedName("chapterName") val chapterName: String,//分类
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("link") val link: String,
    @field:SerializedName("niceDate") val niceDate: String,//时间
    @field:SerializedName("shareUser") val shareUser: String,//分享人
    @field:SerializedName("superChapterName") val superChapterName: String,//分类
    @field:SerializedName("title") val title: String,//标题
)