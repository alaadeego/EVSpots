package com.alrayes.evspots.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alrayes.domain.features.nearby.interactor.GetNearby
import com.alrayes.evspots.features.model.NearbyRequestView
import com.alrayes.evspots.features.model.NearbyView
import com.alrayes.evspots.features.model.toDomain
import com.alrayes.evspots.features.model.toView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var getNearby: GetNearby

    private var _nearbySpots = MutableStateFlow<List<NearbyView>?>(null)
    val nearbySpots: StateFlow<List<NearbyView>?> = _nearbySpots

    init {
     //   fetchNearbySpots()
    }


    fun fetchNearbySpots() {
        val API_KEY = "USE_VALID_API"
        val request = NearbyRequestView(maxResults = 10 )
        viewModelScope.launch(Dispatchers.IO) {
            getNearby.execute(request.toDomain()).collect { spots ->
                _nearbySpots.value =  spots.map { it.toView() }
            }
        }

    }

}