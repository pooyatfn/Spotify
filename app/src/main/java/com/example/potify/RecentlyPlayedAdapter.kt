package com.example.potify

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.potify.databinding.RecentlyPlayedItemBinding

class RecentlyPlayedAdapter: RecyclerView.Adapter<RecentlyPlayedAdapter.ViewHolder>() {

    var recentlies: List<RecentlyPlayedItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecentlyPlayedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = recentlies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recently = recentlies[position]
        holder.bind(recently)
    }

    inner class ViewHolder(private val binding: RecentlyPlayedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recently: RecentlyPlayedItem) {
            binding.recentlyImage.setImageBitmap(BitmapFactory.decodeFile(recently.imageSrc))
            binding.recentlyText.text = recently.title
//          binding.goodImage.apply {
//              setImageBitmap(BitmapFactory.decodeFile(good.image))
//                text = todo.todo
//                setOnCheckedChangeListener(null)
//                isChecked = todo.isChecked
//                setOnCheckedChangeListener { _, isChecked ->
//                    onUpdate.invoke(todo.copy(isChecked = isChecked))
//                }
//          }
//            binding.delete.setOnClickListener {
//                onDelete.invoke(todo)
//            }
        }
    }
}