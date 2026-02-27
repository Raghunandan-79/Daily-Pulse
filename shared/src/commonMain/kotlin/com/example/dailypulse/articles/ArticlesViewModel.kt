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
            val fetchedArticles = fetchArticles()

            delay(500)

            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

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
            imageUrl = "https://media.wired.com/photos/iphone13.jpg"
        ),

        Article(
            title = "Samsung details ‘Galaxy AI’ real-time call translation",
            desc = "In a new blog post, Samsung previewed AI features coming to its smartphones and devices.",
            date = "2023-11-09",
            imageUrl = "https://cdn.vox-cdn.com/galaxy-ai.jpg"
        ),

        Article(
            title = "Google announces new Android 15 developer preview",
            desc = "The next Android version focuses on privacy sandbox improvements and performance.",
            date = "2024-02-12",
            imageUrl = "https://developer.android.com/images/android15.jpg"
        ),

        Article(
            title = "Kotlin Multiplatform reaches stable milestone",
            desc = "JetBrains officially announces KMP stable for production mobile apps.",
            date = "2024-01-20",
            imageUrl = "https://blog.jetbrains.com/kotlin-multiplatform.jpg"
        ),

        Article(
            title = "Jetpack Compose vs XML: Performance comparison",
            desc = "Benchmarks show significant reduction in boilerplate and faster UI iteration speed.",
            date = "2024-02-01",
            imageUrl = "https://developer.android.com/images/compose-performance.jpg"
        ),

        Article(
            title = "OpenAI releases new GPT model for developers",
            desc = "The new model improves reasoning, speed and tool usage for coding assistants.",
            date = "2024-03-10",
            imageUrl = "https://openai.com/research/gpt.jpg"
        ),

        Article(
            title = "Flutter 4 announced with improved rendering engine",
            desc = "Google introduces major improvements to Impeller rendering and desktop support.",
            date = "2024-02-28",
            imageUrl = "https://flutter.dev/images/flutter4.jpg"
        ),

        Article(
            title = "Linux kernel 6.8 improves laptop battery life",
            desc = "New scheduler changes bring noticeable efficiency gains on Intel processors.",
            date = "2024-03-05",
            imageUrl = "https://kernel.org/images/linux.jpg"
        ),

        Article(
            title = "Top programming languages to learn in 2025",
            desc = "Rust, Kotlin and TypeScript dominate modern developer ecosystems.",
            date = "2024-01-01",
            imageUrl = "https://cdn.education.dev/programming.jpg"
        )
    )

}