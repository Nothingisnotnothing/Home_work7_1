package kg.vohkysan.home_work7_1.data.base

import kg.vohkysan.home_work7_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T): Flow<Resource<T>> {
        return flow {
            emit(Resource.Loading())
            try {
                emit(Resource.Success(request()))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }
}