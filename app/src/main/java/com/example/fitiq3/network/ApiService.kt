package com.example.fitiq3.network


import com.example.fitiq3.models.Exercise
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    // Example endpoints — change to match the API you use
    @GET("api/v2/exercise/")
    suspend fun listExercises(@Query("category") categoryId: Int?): ExerciseListResponse


    @GET("api/v2/exercise/")
    suspend fun searchExercises(@Query("search") query: String): ExerciseListResponse
}


// Example mapping class — adjust to API
data class ExerciseListResponse(
    val results: List<ExerciseRaw>
)


// raw mapping from API -> convert to Exercise
data class ExerciseRaw(
    val id: Int,
    val name: String,
    val description: String?,
    val category: Int
)


fun ExerciseRaw.toExercise() = Exercise(id = id, name = name, description = description, category = category)