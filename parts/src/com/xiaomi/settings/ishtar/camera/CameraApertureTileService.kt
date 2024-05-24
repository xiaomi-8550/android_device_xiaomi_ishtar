/*
 * Copyright (C) 2024 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.xiaomi.settings.ishtar.camera

import android.os.SystemProperties
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class CameraApertureTileService : TileService() {

    companion object {
        private const val APERTURE_PROP_KEY = "persist.vendor.camera.manualApertureFnumber"
        private const val APERTURE_PROP_VALUE_OPEN = "1.9"
        private const val APERTURE_PROP_VALUE_CLOSED = "4.0"
    }

    private fun updateUI(apertureValue: String) {
        val tile = qsTile
        tile.label = "Camera Aperture"
        tile.subtitle = apertureValue
        tile.state = Tile.STATE_ACTIVE
        tile.updateTile()
    }

    override fun onStartListening() {
        super.onStartListening()
        updateUI(SystemProperties.get(APERTURE_PROP_KEY, APERTURE_PROP_VALUE_OPEN))
    }

    override fun onStopListening() {
        super.onStopListening()
    }

    override fun onClick() {
        super.onClick()
        val currentApertureValue = SystemProperties.get(APERTURE_PROP_KEY, APERTURE_PROP_VALUE_OPEN)
        val newApertureValue = if (APERTURE_PROP_VALUE_OPEN == currentApertureValue) APERTURE_PROP_VALUE_CLOSED else APERTURE_PROP_VALUE_OPEN
        SystemProperties.set(APERTURE_PROP_KEY, newApertureValue)
        updateUI(newApertureValue)
    }
}
