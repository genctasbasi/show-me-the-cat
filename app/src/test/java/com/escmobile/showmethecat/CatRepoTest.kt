package com.escmobile.showmethecat

import com.escmobile.showmethecat.MockData.mockCatFactResponseSuccess
import com.escmobile.showmethecat.data.CatAPI
import com.escmobile.showmethecat.data.CatRepo
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Before

@ExperimentalCoroutinesApi
class CatRepoTest {

    @RelaxedMockK
    private lateinit var mockAPI: CatAPI

    // sut
    private lateinit var catRepo: CatRepo

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        catRepo = CatRepo(mockAPI)
    }

    @Test
    fun `repo get fact call actually makes the api call`() = runBlocking {
        // given
        coEvery { mockAPI.getCatFact() } returns mockCatFactResponseSuccess

        // when
        catRepo.getCatFact()

        // then
        coVerify { mockAPI.getCatFact() }
    }
}