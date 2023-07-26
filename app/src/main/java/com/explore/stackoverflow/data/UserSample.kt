package com.explore.stackoverflow.data

data class UserSample(
    val id: Int,
    val name: String,
) {
    companion object {
        val userList = listOf(
            UserSample(1, "User 1"),
            UserSample(2, "User 2"),
            UserSample(3, "User 3")
        )
    }
}
