package com.mobdeve.s15.mendoza.precious.exercise2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val postList: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivUserImage: ImageView = itemView.findViewById(R.id.ivUserImage)
        private val tvUsername: TextView = itemView.findViewById(R.id.tvUsername)
        private val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        private val ivPostImage: ImageView = itemView.findViewById(R.id.ivPostImage)
        private val btnLike: ImageButton = itemView.findViewById(R.id.btnLike)
        private val layoutCaption: LinearLayout = itemView.findViewById(R.id.layoutCaption)
        private val tvCaptionUsername: TextView = itemView.findViewById(R.id.tvCaptionUsername)
        private val tvCaption: TextView = itemView.findViewById(R.id.tvCaption)
        private val tvDate: TextView = itemView.findViewById(R.id.tvDate)

        fun bind(post: Post) {
            // Set basic data
            ivUserImage.setImageResource(post.userImageId)
            tvUsername.text = post.username
            ivPostImage.setImageResource(post.imageId)
            tvDate.text = post.datePosted

            // Handle Null Location
            if (post.location == null) {
                tvLocation.visibility = View.GONE
            } else {
                tvLocation.visibility = View.VISIBLE
                tvLocation.text = post.location
            }

            // Handle Null Caption
            if (post.caption == null) {
                layoutCaption.visibility = View.GONE
            } else {
                layoutCaption.visibility = View.VISIBLE
                tvCaptionUsername.text = post.username
                tvCaption.text = post.caption
            }

            // Handle Like Button Initialization
            updateLikeButtonUI(post.liked)

            // Handle Like Button Click Logic
            btnLike.setOnClickListener {
                post.liked = !post.liked
                updateLikeButtonUI(post.liked)
            }
        }

        private fun updateLikeButtonUI(isLiked: Boolean) {
            if (isLiked) {
                // Replace these with your actual heart drawables
                btnLike.setImageResource(R.drawable.ic_heart_filled)
            } else {
                btnLike.setImageResource(R.drawable.ic_heart_outline)
            }
        }
    }
}