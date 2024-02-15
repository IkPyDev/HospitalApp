package com.ikpydev.hospitalapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ikpydev.hospitalapp.data.Users
import com.ikpydev.hospitalapp.databinding.ItemUsersBinding
import java.text.SimpleDateFormat

class UserDiffUtil() : DiffUtil.ItemCallback<Users>() {

    override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
        return oldItem.id == newItem.id

    }

}

class UserAdapter : ListAdapter<Users, UserAdapter.ViewHolder>(UserDiffUtil()) {

    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")


    inner class ViewHolder(private val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(users: Users) = with(binding) {

            name.text = (users.name + " " + users.last)
            val dateString = simpleDateFormat.format(users.data.toLong())
            date.text = dateString
            doctor.text = users.doctor_name + " " + users.doctor_last


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemUsersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}