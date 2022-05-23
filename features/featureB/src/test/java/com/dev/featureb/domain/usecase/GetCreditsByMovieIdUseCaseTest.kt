package com.dev.featureb.domain.usecase

import com.dev.featureb.data.mappers.toDomain
import com.dev.featureb.data.util.MockResponse
import com.dev.featureb.domain.repository.MovieDetailRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

private const val ONCE = 1
private const val MOVIE_ID = 1L

class GetCreditsByMovieIdUseCaseTest {
    private val repository: MovieDetailRepository = mockk()
    private val useCase = GetCreditsByMovieIdUseCase(repository)

    @Test
    fun `invoke should return Credits from repository has success`() = runBlocking {
        // Given
        val expectedResult = MockResponse.fakeCreditsResponse().toDomain()
        every { repository.getCreditsByMovieId(MOVIE_ID) } returns flowOf(expectedResult)

        // When
        val result = useCase(MOVIE_ID)

        // Then
        verify(exactly = ONCE) { repository.getCreditsByMovieId(MOVIE_ID) }
        assertEquals(expectedResult, result)
    }

    @Test
    fun `invoke should return error from repository has error`() {
        // Given
        val error = NullPointerException()
        every { repository.getCreditsByMovieId(MOVIE_ID) } returns flow { throw error }

        // When
        runBlocking {
            runCatching {
                useCase(MOVIE_ID)
            }.onFailure {
                verify(exactly = ONCE) { repository.getCreditsByMovieId(MOVIE_ID) }
                assertEquals(error, it)
            }
        }
    }
}