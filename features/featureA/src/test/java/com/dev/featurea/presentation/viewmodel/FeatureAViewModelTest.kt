package com.dev.featurea.presentation.viewmodel

import com.dev.featurea.domain.model.MovieResult
import com.dev.featurea.domain.usecase.GetPopularMoviesUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
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
import kotlin.test.assertTrue
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
class FeatureAViewModelTest {
    private val fakeMovieResult = MovieResult(results = emptyList())
    private val useCase: GetPopularMoviesUseCase = mockk()
    private val dispatcher = UnconfinedTestDispatcher()
    private val viewModel =
        FeatureAViewModel(useCase = useCase, dispatcher = dispatcher)

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `getPopularMovies should set correct states when useCase returns success`() =
        runBlocking {
            // Given
            val initialState = MovieUiState()
            val loadingState = initialState.showLoading()
            val successState = loadingState.showMovies(fakeMovieResult.results)
            val testResults = arrayListOf<MovieUiState>()
            val job = launch(dispatcher) { viewModel.uiState.toList(destination = testResults) }
            every { useCase() } returns flowOf(fakeMovieResult)

            // When
            viewModel.getPopularMovies()

            // Then
            assertEquals(3, testResults.size)
            assertEquals(initialState, testResults[0])
            assertEquals(loadingState, testResults[1])
            assertEquals(successState, testResults[2])

            job.cancel()
        }

    @Test
    fun `getPopularMovies should set correct states when useCase returns error`() =
        runBlocking {
            // Given
            val initialState = MovieUiState()
            val loadingState = initialState.showLoading()
            val errorState = loadingState.showError()
            val testResults = arrayListOf<MovieUiState>()
            val job = launch(dispatcher) { viewModel.uiState.toList(destination = testResults) }
            every { useCase() } returns flow { throw Exception() }

            // When
            viewModel.getPopularMovies()

            // Then
            assertEquals(3, testResults.size)
            assertEquals(initialState, testResults[0])
            assertEquals(loadingState, testResults[1])
            assertEquals(errorState, testResults[2])
            job.cancel()
        }

    @Test
    fun `onClickItemList should call MovieUiAction NavToDetailMovie action`() = runBlocking {
        val testResults = arrayListOf<MovieUiAction>()

        val job = launch(dispatcher) {
            viewModel.uiAction.toList(destination = testResults)
        }

        // When
        viewModel.onClickItemList(idMovie = 1)

        // Then
        assertEquals(1, testResults.size)
        assertTrue(testResults[0] is MovieUiAction.NavToDetailMovie)

        job.cancel()
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}