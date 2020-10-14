package com.longjunhao.pagingwithnetworksample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.longjunhao.pagingwithnetworksample.adapters.HomeActicleAdapter
import com.longjunhao.pagingwithnetworksample.databinding.ActivityMainBinding
import com.longjunhao.pagingwithnetworksample.viewmodels.HomeActicleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var homeJob: Job? = null
    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel : HomeActicleViewModel by viewModels()
    private val mHomeActicleAdapter = HomeActicleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mBinding.apply {
            homeActicleList.adapter = mHomeActicleAdapter
            lifecycleOwner = this@MainActivity
        }

        homeJob?.cancel()
        homeJob = lifecycleScope.launch() {
            mViewModel.getHomeActicle(0).collectLatest {
                mHomeActicleAdapter.submitData(it)
            }
        }

    }
}