package com.applications.konovodov_hw_4_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timestamp = 12825216
        val post = Post(
            1,
            "Konovodov V.A.",
            "23 August 2020",
            "First post in your network!",
            timestamp,
            5,
            1
        )

        contentTv.text = post.content
        //startDateTv.text = post.date
        startDateTv.text = post.publishedAgo()
        postAuthor.text = post.author
        likeCounter.text = post.likeCounter.toString()
        if (post.likeCounter != 0) {
            likeImageBtn.setImageResource(R.drawable.ic_favorite_active)
            likeCounter.setTextColor(getColor(R.color.likeColorActive))
        } else {
            likeImageBtn.setImageResource(R.drawable.ic_favorite_disabled)
            likeCounter.setTextColor(getColor(R.color.likeColorPassive))
        }

        likeImageBtn.setOnClickListener() {
            if (post.likeCounter == 0) {
                likeImageBtn.setImageResource(R.drawable.ic_favorite_active)
                likeCounter.setTextColor(getColor(R.color.likeColorActive))
                post.likeCounter = post.likeCounter + 1
                likeCounter.text = post.likeCounter.toString()

            } else {
                post.likeCounter = post.likeCounter - 1
                if (post.likeCounter == 0) {
                    likeImageBtn.setImageResource(R.drawable.ic_favorite_disabled)
                    likeCounter.setTextColor(getColor(R.color.likeColorPassive))
                    likeCounter.text = " "
                } else {
                    likeCounter.text = post.likeCounter.toString()
                }
            }

        }


    }


}