package kg.vohkysan.home_work7_1.domain.models

import java.io.Serializable

data class Family(
    val id: Int,
    val name: String,
    val mother: String,
    val father: String
) : Serializable
