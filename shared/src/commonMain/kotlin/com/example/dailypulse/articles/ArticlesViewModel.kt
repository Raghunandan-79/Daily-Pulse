package com.example.dailypulse.articles

import com.example.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(1000)

            val fetchedArticles = fetchArticles()

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(

        Article(
            title = "Stock market today: Live updates — CNBC",
            desc = "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            date = "2023-11-09",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages.jpg"
        ),

        Article(
            title = "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
            desc = "Apple's smartphones rarely go on sale, but if you're looking to upgrade, here are deals worth checking.",
            date = "2023-11-09",
            imageUrl = "https://i.pcmag.com/imagery/articles/00kHKyr2txugAMOfHliCYlQ-1.fit_lim.size_1600x900.v1771350406.jpg"
        ),

        Article(
            title = "Samsung details ‘Galaxy AI’ real-time call translation",
            desc = "In a new blog post, Samsung previewed AI features coming to its smartphones and devices.",
            date = "2023-11-09",
            imageUrl = "https://i.pcmag.com/imagery/articles/07m1whavZpgrfnN35NBulOu-1.fit_lim.size_1600x900.v1768474251.jpg"
        ),

        Article(
            title = "Google announces new Android 15 developer preview",
            desc = "The next Android version focuses on privacy sandbox improvements and performance.",
            date = "2024-02-12",
            imageUrl = "https://i.pcmag.com/imagery/reviews/01NLCz6EjLkgLrk5BIui4DH-1.fit_scale.size_1028x578.v1729603899.png"
        ),

        Article(
            title = "OpenAI releases new GPT model for developers",
            desc = "The new model improves reasoning, speed and tool usage for coding assistants.",
            date = "2024-03-10",
            imageUrl = "https://i.pcmag.com/imagery/articles/07EMLd5c4eT9sFNeKG09wgs-1.fit_lim.size_1600x900.v1754557688.jpg"
        ),

    )

}