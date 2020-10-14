package com.longjunhao.pagingwithnetworksample.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.longjunhao.pagingwithnetworksample.data.HomeActicleItem
import com.longjunhao.pagingwithnetworksample.data.HomeActicleRepository
import kotlinx.coroutines.flow.Flow

/**
 * .HomeActicleViewModel
 *
 * @author Admitor
 * @date 2020/09/24
 */
class HomeActicleViewModel @ViewModelInject constructor(
    val repository: HomeActicleRepository
) : ViewModel() {
    private var currentPageIndex: Int? = 0
    private var currentPageResult: Flow<PagingData<HomeActicleItem>>? = null

    fun getHomeActicle(pageIndex: Int): Flow<PagingData<HomeActicleItem>> {
        currentPageIndex = pageIndex
        var newResult: Flow<PagingData<HomeActicleItem>> =
            repository.getHomeActicles(pageIndex).cachedIn(viewModelScope)
        currentPageResult = newResult
        return newResult
    }
}