package com.escmobile.showmethecat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.escmobile.showmethecat.MockData.mockCatFact
import com.escmobile.showmethecat.MockData.mockCatViewFact
import com.escmobile.showmethecat.data.CatRepo
import com.escmobile.showmethecat.ui.viewModule.CatViewModel
import com.escmobile.showmethecat.ui.viewModule.CatViewState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any

@ExperimentalCoroutinesApi
class CatViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var mockRepo: CatRepo

    @RelaxedMockK
    lateinit var mockObserver: Observer<CatViewState>

    // sut
    private lateinit var catViewModel: CatViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        catViewModel = CatViewModel(mockRepo)
    }

    @Test
    fun `view model get fact call makes the repo call`() {
        // given
        coEvery { mockRepo.getCatFact() } returns mockCatFact

        // when
        catViewModel.getCatFact()

        // then
        coVerify { mockRepo.getCatFact() }
    }

    @Test
    fun `cat fact observer changes`() {

        // given
        catViewModel.catFactResult.observeForever(mockObserver)
        coEvery { mockRepo.getCatFact() } returns mockCatFact

        // when
        catViewModel.getCatFact()

        // then
        coVerify { mockObserver.onChanged(mockCatViewFact) }
    }

    @Test
    fun `in progress state is set making the fact call`() {

        // given
        catViewModel.catFactResult.observeForever(mockObserver)
        coEvery { mockRepo.getCatFact() } returns any()

        // when
        catViewModel.getCatFact()

        // then
        coVerify { mockObserver.onChanged(CatViewState.InProgress) }
    }

    @Test
    fun `error state is set when no fact is returned`() {

        // given
        catViewModel.catFactResult.observeForever(mockObserver)
        coEvery { mockRepo.getCatFact() } returns null

        // when
        catViewModel.getCatFact()

        // then
        coVerify { mockObserver.onChanged(CatViewState.Error) }
    }
}