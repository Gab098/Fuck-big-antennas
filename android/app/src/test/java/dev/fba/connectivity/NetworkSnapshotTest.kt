package dev.fba.connectivity

import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkSnapshotTest {
    @Test
    fun disconnectedSnapshotHasClearStatus() {
        assertEquals("No default network", NetworkSnapshot().statusLabel)
    }

    @Test
    fun validatedNetworkReportsInternetValidated() {
        val snapshot = NetworkSnapshot(
            transport = "Wi-Fi",
            hasInternetCapability = true,
            validated = true,
            metered = false,
            connected = true
        )

        assertEquals("Internet validated", snapshot.statusLabel)
    }

    @Test
    fun internetCapabilityWithoutValidationIsDistinguished() {
        val snapshot = NetworkSnapshot(
            transport = "Mobile data",
            hasInternetCapability = true,
            validated = false,
            metered = true,
            connected = true
        )

        assertEquals("Internet capability, not validated", snapshot.statusLabel)
    }

    @Test
    fun connectedNetworkWithoutInternetCapabilityIsDistinguished() {
        val snapshot = NetworkSnapshot(
            transport = "Ethernet",
            hasInternetCapability = false,
            validated = false,
            metered = false,
            connected = true
        )

        assertEquals("Connected, no Internet capability", snapshot.statusLabel)
    }
}
