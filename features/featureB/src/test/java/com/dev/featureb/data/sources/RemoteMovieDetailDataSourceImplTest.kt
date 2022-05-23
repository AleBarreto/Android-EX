package com.dev.featureb.data.sources

import app.cash.turbine.test
import com.dev.featureb.data.model.response.CreditsResponse
import com.dev.featureb.data.model.response.MovieResultDetailResponse
import com.dev.featureb.data.service.FeatureBService
import com.dev.featureb.data.util.MockResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Exception
import kotlin.test.assertEquals

private const val MOVIE_ID = 1L
private const val ONCE = 1

class RemoteMovieDetailDataSourceImplTest {
    private val service: FeatureBService = mockk()
    private val remoteDataSource: RemoteMovieDetailDataSource =
        RemoteMovieDetailDataSourceImpl(service)

    @Test
    fun `getMovieDetail should return success flow when service returns success response`() =
        runBlocking {
            // Given
            val response = MockResponse.fakeMovieResultDetailResponse()
            coEvery { service.getMovieDetail(MOVIE_ID) } returns response

            // When
            val result = remoteDataSource.getMovieDetail(MOVIE_ID)

            // Then
            result.test {
                coVerify(exactly = ONCE) { service.getMovieDetail(MOVIE_ID) }
                assertEquals(response, awaitItem())
                awaitComplete()
            }
        }

    @Test
    fun `getMovieDetail should return error flow when service returns error response`() =
        runBlocking {
            // Given
            val error = Exception()
            coEvery { service.getMovieDetail(MOVIE_ID) }.throws(error)

            // When
            val result = remoteDataSource.getMovieDetail(MOVIE_ID)

            // Then
            result.test {
                coVerify(exactly = ONCE) { service.getMovieDetail(MOVIE_ID) }
                assertEquals(error, awaitError())
                expectNoEvents()
            }
        }

    @Test
    fun `getCreditsByMovieId should return success flow when service returns success response`() =
        runBlocking {
            // Given
            val response = MockResponse.fakeCreditsResponse()
            coEvery { service.getCreditsByMovieId(MOVIE_ID) } returns response

            // When
            val result = remoteDataSource.getCreditsByMovieId(MOVIE_ID)

            // Then
            result.test {
                coVerify(exactly = ONCE) { service.getCreditsByMovieId(MOVIE_ID) }
                assertEquals(response, awaitItem())
                awaitComplete()
            }
        }

    @Test
    fun `getCreditsByMovieId should return error flow when service returns error response`() =
        runBlocking {
            // Given
            val error = Exception()
            coEvery { service.getCreditsByMovieId(MOVIE_ID) }.throws(error)

            // When
            val result = remoteDataSource.getCreditsByMovieId(MOVIE_ID)

            // Then
            result.test {
                coVerify(exactly = ONCE) { service.getCreditsByMovieId(MOVIE_ID) }
                assertEquals(error, awaitError())
                expectNoEvents()
            }
        }
}
