package com.escmobile.showmethecat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.escmobile.showmethecat.MockData.mockCatFact
import com.escmobile.showmethecat.MockData.mockCatViewResult
import com.escmobile.showmethecat.data.CatRepo
import com.escmobile.showmethecat.ui.viewModule.CatViewModel
import com.escmobile.showmethecat.ui.viewModule.CatViewResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CatViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var mockRepo: CatRepo

    @RelaxedMockK
    lateinit var mockObserver: Observer<CatViewResult>

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
        coVerify { mockObserver.onChanged(mockCatViewResult) }
    }
}