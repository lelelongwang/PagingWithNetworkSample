package com.longjunhao.pagingwithnetworksample.adapters

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.longjunhao.pagingwithnetworksample.R
import com.longjunhao.pagingwithnetworksample.data.HomeActicleItem
import com.longjunhao.pagingwithnetworksample.databinding.HomeActicleListItemBinding
import com.longjunhao.pagingwithnetworksample.adapters.HomeActicleAdapter.HomeActicleViewHoler
/**
 * .HomeActicleAdapter
 *
 * @author Admitor
 * @date 2020/09/28
 */
class HomeActicleAdapter :
    PagingDataAdapter<HomeActicleItem, HomeActicleViewHoler>(HomeActicleDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeActicleViewHoler {
        return HomeActicleViewHoler(
            HomeActicleListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeActicleViewHoler, position: Int) {
        val acticle = getItem(position)
        if (acticle != null) {
            holder.bind(acticle)
        }
    }

    class HomeActicleViewHoler(
        private val binding: HomeActicleListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.acticle?.let { arcticle ->
                    val uri = Uri.parse(arcticle.link)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    view.context.startActivity(intent)
                }
            }
        }

        fun bind(item: HomeActicleItem) {
            binding.apply {
                acticle = item
                executePendingBindings()
            }
        }
    }
}

private class HomeActicleDiffCallback : DiffUtil.ItemCallback<HomeActicleItem>() {
    override fun areItemsTheSame(oldItem: HomeActicleItem, newItem: HomeActicleItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeActicleItem, newItem: HomeActicleItem): Boolean {
        return oldItem == newItem
    }
}