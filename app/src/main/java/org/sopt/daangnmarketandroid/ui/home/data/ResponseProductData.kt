package org.sopt.daangnmarketandroid.ui.home.data

data class ResponseProductData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val id: Int,
        val img: String,
        val title: String,
        val category: String,
        val price: Int,
        val state: String,
        val trade: String,
        val content: String,
        val isDeleted: Boolean,
        val createdAt: String,
        val userId: Int,
        val address: String
    )
}
