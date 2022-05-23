package com.dev.featureb.data.repository

import app.cash.turbine.test
import com.dev.featureb.data.mappers.toDomain
import com.dev.featureb.data.sources.RemoteMovieDetailDataSource
import com.dev.featureb.data.util.MockResponse
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

private const val MOVIE_ID = 1L
private const val ONCE = 1

class MovieDetailRepositoryImplTest {
    private val detailDataSource: RemoteMovieDetailDataSource = mockk()
    private val repository = MovieDetailRepositoryImpl(detailDataSource)


    @Test
    fun `getMovieDetail should return success flow when RemoteMovieDetailDataSource returns success response`() =
        runBlocking {
            // Given
            val responseData = MockResponse.fakeMovieResultDetailResponse()
            val responseDomain = responseData.toDomain()
            every { detailDataSource.getMovieDetail(MOVIE_ID) } returns flowOf(
                responseData
            )

            // When
            val result = repository.getMovieDetail(MOVIE_ID)

            // Then
            result.test {
                verify(exactly = ONCE) { detailDataSource.getMovieDetail(MOVIE_ID) }
                assertEquals(responseDomain, awaitItem())
                awaitComplete()
            }
        }

    @Test
    fun `getMovieDetail should return error flow when RemoteMovieDetailDataSource returns error response`() =
        runBlocking {
            // Given
            val error = Exception()
            every { detailDataSource.getMovieDetail(MOVIE_ID) } returns flow { throw error }

            // When
            val result = repository.getMovieDetail(MOVIE_ID)

            // Then
            result.test {
                verify(exactly = ONCE) { detailDataSource.getMovieDetail(MOVIE_ID) }
                assertEquals(error, awaitError())
                expectNoEvents()
            }
        }

    @Test
    fun `getCreditsByMovieId should return success flow when RemoteMovieDetailDataSource returns success response`() =
        runBlocking {
            // Given
            val responseData = MockResponse.fakeCreditsResponse()
            val responseDomain = responseData.toDomain()
            every { detailDataSource.getCreditsByMovieId(MOVIE_ID) } returns flowOf(
                responseData
            )

            // When
            val result = repository.getCreditsByMovieId(MOVIE_ID)

            // Then
            result.test {
                verify(exactly = ONCE) { detailDataSource.getCreditsByMovieId(MOVIE_ID) }
                assertEquals(responseDomain, awaitItem())
                awaitComplete()
            }
        }

    @Test
    fun `getCreditsByMovieId should return error flow when RemoteMovieDetailDataSource returns error response`() =
        runBlocking {
            // Given
            val error = Exception()
            every { detailDataSource.getCreditsByMovieId(MOVIE_ID) } returns flow { throw error }

            // When
            val result = repository.getCreditsByMovieId(MOVIE_ID)

            // Then
            result.test {
                verify(exactly = ONCE) { detailDataSource.getCreditsByMovieId(MOVIE_ID) }
                assertEquals(error, awaitError())
                expectNoEvents()
            }
        }
}
