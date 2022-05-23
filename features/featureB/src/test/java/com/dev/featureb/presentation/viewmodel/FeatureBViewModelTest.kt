package com.dev.featureb.presentation.viewmodel

import com.dev.featureb.data.mappers.toDomain
import com.dev.featureb.data.util.MockResponse
import com.dev.featureb.domain.usecase.GetCreditsByMovieIdUseCase
import com.dev.featureb.domain.usecase.GetMovieDetailUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.lang.Exception
import kotlin.test.assertEquals

private const val ONCE = 1
private const val MOVIE_ID = 1L

@ExperimentalCoroutinesApi
class FeatureBViewModelTest {

    private val getMovieDetailUseCase: GetMovieDetailUseCase = mockk()
    private val getCreditsByMovieIdUseCase: GetCreditsByMovieIdUseCase = mockk()
    private val dispatcher = UnconfinedTestDispatcher()
    private val viewModel = FeatureBViewModel(
        getMovieDetailUseCase, getCreditsByMovieIdUseCase, dispatcher
    )

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `getDetailsMovieById should set correct states when useCases returns success`() =
        runBlocking {
            // Given
            val movieDetailResult = MockResponse.fakeMovieResultDetailResponse().toDomain()
            val creditsResult = MockResponse.fakeCreditsResponse().toDomain()
            val initialState = DetailsUiState()
            val loadingState = initialState.showLoading()
            val successState = loadingState.setDetailsState(movieDetailResult, creditsResult)
            coEvery { getMovieDetailUseCase(MOVIE_ID) } returns movieDetailResult
            coEvery { getCreditsByMovieIdUseCase(MOVIE_ID) } returns creditsResult

            val testResults = arrayListOf<DetailsUiState>()

            val job = launch(dispatcher) { viewModel.uiState.toList(destination = testResults) }

            // When
            viewModel.getDetailsMovieById(MOVIE_ID)

            coVerify(exactly = ONCE) { getMovieDetailUseCase(MOVIE_ID) }
            coVerify(exactly = ONCE) { getCreditsByMovieIdUseCase(MOVIE_ID) }

            // Then
            assertEquals(3, testResults.size)
            assertEquals(initialState, testResults[0])
            assertEquals(loadingState, testResults[1])
            assertEquals(successState, testResults[2])

            job.cancel()
        }

    @Test
    fun `getDetailsMovieById should set correct states when useCases returns error`() =
        runBlocking {
            // Given
            val initialState = DetailsUiState()
            val loadingState = initialState.showLoading()
            val errorState = loadingState.showError()
            val error = Exception()
            coEvery { getMovieDetailUseCase(MOVIE_ID) }.throws(error)
            coEvery { getCreditsByMovieIdUseCase(MOVIE_ID) }.throws(error)

            val testResults = arrayListOf<DetailsUiState>()

            val job = launch(dispatcher) { viewModel.uiState.toList(destination = testResults) }

            // When
            viewModel.getDetailsMovieById(MOVIE_ID)

            // Then
            assertEquals(3, testResults.size)
            assertEquals(initialState, testResults[0])
            assertEquals(loadingState, testResults[1])
            assertEquals(errorState, testResults[2])

            job.cancel()
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}