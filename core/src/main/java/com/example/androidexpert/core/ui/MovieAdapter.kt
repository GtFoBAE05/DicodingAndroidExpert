package com.example.androidexpert.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidexpert.core.R
import com.example.androidexpert.core.databinding.ItemListMovieBinding
import com.example.androidexpert.core.domain.model.MovieItem
import com.example.androidexpert.core.utils.DiffUtilCallback
import java.util.ArrayList

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.ListViewHolder>()   {

    private var listData = ArrayList<MovieItem>()
    var onItemClick: ((MovieItem) -> Unit)? = null

    fun setData(newListData: List<MovieItem>?) {
        if (newListData == null) return

        val diffResult = DiffUtil.calculateDiff(MovieDiffUtilCallback(listData, newListData))
        listData.clear()
        listData.addAll(newListData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: MovieItem) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500"+data.posterPath)
                    .into(ivItemImage)
                tvItemTitle.text = data.title
                tvItemSubtitle.text = data.overview
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }

    private class MovieDiffUtilCallback(
        private val oldList: List<MovieItem>,
        private val newList: List<MovieItem>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]
    }


}