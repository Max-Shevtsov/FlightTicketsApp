package com.max.booking_flights_data.repositories




import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.max.booking_flights_data.db.DepartureTownDb
import com.max.booking_flights_data.mappers.toDeparturesTown
import com.max.booking_flights_domain.repositories.DeparturesTownRepository
import kotlinx.coroutines.flow.map


const val DataStore_NAME = "DEPARTURES_TOWN"

val Context.datastore : DataStore< Preferences> by  preferencesDataStore(name = DataStore_NAME)



class DeparturesTownRepositoryImpl(
    private val context: Context
) : DeparturesTownRepository {
    companion object {
        val TOWN = stringPreferencesKey("town")
    }

    override suspend fun saveDeparturesTown(departuresTown: String) {
    context.datastore.edit { town -> town[TOWN] = departuresTown }
    }

   override suspend fun getDeparturesTown() = context.datastore.data.map { town ->
        DepartureTownDb(
            departuresTown = town.toString()
        ).toDeparturesTown()
    }

}

