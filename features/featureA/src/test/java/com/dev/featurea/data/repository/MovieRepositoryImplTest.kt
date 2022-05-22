package com.dev.featurea.data.repository

import app.cash.turbine.test
import com.dev.featurea.data.mappers.toDomain
import com.dev.featurea.data.model.response.MovieResultResponse
import com.dev.featurea.data.sources.RemoteMovieDataSource
import com.dev.featurea.domain.repository.MovieRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

private const val ONCE = 1

@ExperimentalTime
class MovieRepositoryImplTest {
    private val remoteMovieDataSource: RemoteMovieDataSource = mockk()
    private val repositoryImpl: MovieRepository = MovieRepositoryImpl(remoteMovieDataSource)
    private val movieResultResponse = MovieResultResponse(results = emptyList())

    @Test
    fun `getPopularMovies should return success flow when remoteMovieDataSource returns success response`() {
        // Given
        val expectedData = movieResultResponse.toDomain()
        every { remoteMovieDataSource.getPopularMovies() } returns flow { emit(movieResultResponse) }

        // When
        val result = repositoryImpl.getPopularMovies()

        // Then
        runBlocking {
            result.test {
                verify(exactly = ONCE) { remoteMovieDataSource.getPopularMovies() }
                assertEquals(awaitItem(), expectedData)
                awaitComplete()
            }
        }
    }

    @Test
    fun `getPopularMovies should return error flow when remoteMovieDataSource returns error response`() {
        // Given
        val error = Exception()
        every { remoteMovieDataSource.getPopularMovies() } returns flow { throw error }

        // When
        val result = repositoryImpl.getPopularMovies()

        // Then
        runBlocking {
            result.test {
                verify(exactly = ONCE) { remoteMovieDataSource.getPopularMovies() }
                assertEquals(awaitError(), error)
                expectNoEvents()
            }
        }
    }
}