package com.example.sample.data.repository

import com.example.mvvmexample.util.network.NetworkState
import com.example.mvvmexample.util.network.RetrofitFailureStateException
import com.example.sample.data.api.MovieApiService
import com.example.sample.model.UiMoviePopular
import com.example.sample.model.toUiMoviePopularModel
import timber.log.Timber
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieApiService: MovieApiService): MovieRepository  {
    override suspend fun getMoviePopular(language: String, page: Int, region: String?): Result<List<UiMoviePopular>> {
        when(val moviePopularList =
            movieApiService.getMoviePopular(language = language, page = page, region = region)) {
            is NetworkState.Success -> return Result.success(moviePopularList.body.toUiMoviePopularModel())
            is NetworkState.Failure -> return Result.failure(
                RetrofitFailureStateException(moviePopularList.error, moviePopularList.code)
            )
            is NetworkState.NetworkError -> Timber.tag("${this.javaClass.name}_getSearchBook").d(moviePopularList.error)
            is NetworkState.UnknownError -> Timber.tag("${this.javaClass.name}_getSearchBook").d(moviePopularList.t)
        }
        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))
    }
}