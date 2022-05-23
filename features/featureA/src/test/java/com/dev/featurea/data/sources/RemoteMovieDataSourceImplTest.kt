package com.dev.featurea.data.sources

import app.cash.turbine.test
import com.dev.featurea.data.model.response.MovieResultResponse
import com.dev.featurea.data.service.FeatureAService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Exception
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

private const val ONCE = 1

class RemoteMovieDataSourceImplTest {

    private val service: FeatureAService = mockk()
    private val dataSource: RemoteMovieDataSource = RemoteMovieDataSourceImpl(service)

    @Test
    fun `getPopularMovies should return success flow when service returns success response`() {
        // Given
        val fakeResponse = MovieResultResponse(results = emptyList())
        coEvery { service.getPopularMovies() } returns fakeResponse

        // When
        val result = dataSource.getPopularMovies()

        // Then
        runBlocking {
            result.test {
                coVerify(exactly = ONCE) { service.getPopularMovies() }
                assertEquals(fakeResponse, awaitItem())
                awaitComplete()
            }
        }
    }

    @Test
    fun `getPopularMovies should return error flow when service returns error response`() {
        // Given
        val error = Exception()
        coEvery { service.getPopularMovies() }.throws(error)

        // When
        val result = dataSource.getPopularMovies()

        // Then
        runBlocking {
            result.test {
                coVerify(exactly = ONCE) { service.getPopularMovies() }
                assertEquals(awaitError(), error)
                expectNoEvents()
            }
        }
    }
}