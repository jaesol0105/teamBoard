package com.beinny.teamboard.ui.home.boardList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beinny.teamboard.databinding.ItemBookmarkBinding
import com.beinny.teamboard.models.Board

class BookmarkedBoardsAdapter(
    private val callback: BoardListFragment.AdapterCallback
) : ListAdapter<Board, BookmarkedBoardsAdapter.BookmarkedBoardsViewHolder>(BookMarkedBoardsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkedBoardsViewHolder {
        val binding = ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookmarkedBoardsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarkedBoardsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BookmarkedBoardsViewHolder(private val binding: ItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(board: Board) {
            binding.root.setOnClickListener { callback.onClick(board) }
            binding.board = board
            binding.executePendingBindings()
        }
    }
}

class BookMarkedBoardsDiffCallback : DiffUtil.ItemCallback<Board>() {
    override fun areItemsTheSame(oldItem: Board, newItem: Board): Boolean {
        return oldItem.documentId == newItem.documentId
    }

    override fun areContentsTheSame(oldItem: Board, newItem: Board): Boolean {
        return oldItem == newItem
    }
}