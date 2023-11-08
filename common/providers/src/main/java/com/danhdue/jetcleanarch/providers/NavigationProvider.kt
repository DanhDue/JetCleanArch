package com.danhdue.jetcleanarch.providers

interface NavigationProvider {
    fun openCharacterDetail(characterId: Int)
    fun openEpisodeDetail(episodeId: Int)
    fun openLocationDetail(locationId: Int)
    fun openTermAndPrivacy()
    fun openAppLanguage()
    fun openAbout()
    fun navigateUp()
}
