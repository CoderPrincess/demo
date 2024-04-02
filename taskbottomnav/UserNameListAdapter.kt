package com.example.taskbottomnav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbottomnav.databinding.CardViewBinding

class UserNameListAdapter : ListAdapter<UserDataClass, UserNameListAdapter.UserViewHolder>(UserComparator()) {

// onCreateViewHolder - It sets the view to display the items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }   // Todo - withViewHolder and withoutViewHolder in base & getItemViewType

// onBindViewHolder - It is used to bind the list items to widgets such as textView, ImageView etc

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class UserViewHolder(private val binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserDataClass) {
            binding.userId = user
            binding.password = user
        }
    }

    class UserComparator : DiffUtil.ItemCallback<UserDataClass>() {
        override fun areItemsTheSame(oldItem: UserDataClass, newItem: UserDataClass): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserDataClass, newItem: UserDataClass): Boolean {
            return oldItem == newItem
        }
    }

}

// DiffUtil - Helps in computing the difference between two lists or sets of data efficiently
