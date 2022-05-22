package com.dev.featurea.domain.usecase

import app.cash.turbine.test
import com.dev.featurea.domain.model.MovieResult
import com.dev.featurea.domain.repository.MovieRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

private const val ONCE = 1

@ExperimentalTime
class GetPopularMoviesUseCaseTest {
    private val repository: MovieRepository = mockk()
    private val useCase = GetPopularMoviesUseCase(repository)

    @Test
    fun `invoke should return movieResult from repository`() {
        // Given
        val expectedResult = MovieResult(results = emptyList())
        every { repository.getPopularMovies() } returns flowOf(expectedResult)

        // When
        val result = useCase()

        // Then
        runBlocking {
            result.test {
                verify(exactly = ONCE) { repository.getPopularMovies() }
                assertEquals(awaitItem(), expectedResult)
                awaitComplete()
            }
        }
    }

    @Test
    fun `invoke should return error from repository has error`() {
        // Given
        val error = Exception()
        every { repository.getPopularMovies() } returns flow { throw error }

        // When
        val result = useCase()

        // Then
        runBlocking {
            result.test {
                verify(exactly = ONCE) { repository.getPopularMovies() }
                assertEquals(awaitError(), error)
                expectNoEvents()
            }
        }
    }
}