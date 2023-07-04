package kg.vohkysan.home_work7_1.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kg.vohkysan.home_work7_1.data.local.FamilyDao
import kg.vohkysan.home_work7_1.data.local.FamilyDataBase
import kg.vohkysan.home_work7_1.data.repositories.FamilyRepositoryImpl
import kg.vohkysan.home_work7_1.domain.repositories.FamilyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FamilyModule {

    @Singleton
    @Provides
    fun provideFamilyDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        FamilyDataBase::class.java,
        "contact_db"
    )

    @Provides
    fun provideFamilyDao(familyDataBase: FamilyDataBase) = familyDataBase.familyDao()

    @Provides
    fun provideFamilyRepository(familyDao: FamilyDao): FamilyRepository {
        return FamilyRepositoryImpl(familyDao = familyDao)
    }
}