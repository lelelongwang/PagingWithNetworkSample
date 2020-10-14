package com.longjunhao.pagingwithnetworksample.data

import androidx.paging.PagingSource
import com.longjunhao.pagingwithnetworksample.api.WanandroidApi

/**
 * .HomeActiclePagingSource
 *
 * @author Admitor
 * @date 2020/09/23
 */

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class HomeActiclePagingSource(
    private val api: WanandroidApi,
    private val page: Int
) : PagingSource<Int,HomeActicleItem>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeActicleItem> {
        val page = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = api.getHomeActicle(page)
            val datas = response.datas.datas
            LoadResult.Page(
                data = datas,
                prevKey = if (page == UNSPLASH_STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == response.datas.pageCount) null else page + 1
            )
        }catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}