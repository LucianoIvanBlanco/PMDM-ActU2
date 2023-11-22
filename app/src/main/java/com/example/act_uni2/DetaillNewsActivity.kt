package com.example.act_uni2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.act_uni2.databinding.ActivityDetaillNewsBinding
import com.example.act_uni2.data.getSport
import com.example.misnoticias.data.getTech
import getAllNews


class DetaillNewsActivity : AppCompatActivity() {


    private lateinit var _binding: ActivityDetaillNewsBinding
    private val binding: ActivityDetaillNewsBinding get() = _binding

    private lateinit var title: TextView
    private lateinit var image: ImageView
    private lateinit var author: TextView
    private lateinit var description: TextView

    private lateinit var idTitle: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetaillNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
        idTitle = recoverData()
        setFragment(idTitle)
    }

    private fun initComponents() {
        title = binding.tvDetailTitle
        image = binding.ivDatail
        author = binding.tvDetailAuthor
        description = binding.tvDetailDescription
    }

    private fun recoverData(): String {
        val id = intent.getStringExtra("title")
        return id.toString()
    }

    private fun setFragment(idTitle: String) {
        val list = getTech() + getSport() + getAllNews()

        for (news in list) {
            if (news.title == idTitle) {
                title.text = news.title
                Glide.with(binding.root)
                    .load(news.image)
                    .into(binding.ivDatail)
                author.text = news.author
                description.text = news.description

                break
            }
        }

    }


}


