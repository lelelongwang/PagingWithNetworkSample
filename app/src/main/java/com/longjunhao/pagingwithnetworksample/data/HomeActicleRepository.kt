package com.longjunhao.pagingwithnetworksample.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.longjunhao.pagingwithnetworksample.api.WanandroidApi
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * .HomeActicleRepository
 *
 * @author Admitor
 * @date 2020/09/24
 */

class HomeActicleRepository @Inject constructor(
    private val api: WanandroidApi
) {
    fun getHomeActicles(page: Int): Flow<PagingData<HomeActicleItem>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { HomeActiclePagingSource(api, page) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}