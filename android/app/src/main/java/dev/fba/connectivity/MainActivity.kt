package dev.fba.connectivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    private lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        networkMonitor = NetworkMonitor(applicationContext)
        networkMonitor.start()

        setContent {
            MaterialTheme {
                val snapshot by networkMonitor.snapshot.collectAsState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "FBA Connectivity",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = "Connectivity observer · prototype 0.1.0",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceContainer
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(18.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text("DEFAULT NETWORK", style = MaterialTheme.typography.labelMedium)
                                Text(
                                    snapshot.transport,
                                    style = MaterialTheme.typography.headlineSmall
                                )
                                Text(snapshot.statusLabel)
                                StatusRow("Connected", yesNo(snapshot.connected))
                                StatusRow("Internet capability", yesNo(snapshot.hasInternetCapability))
                                StatusRow("Validated by Android", yesNo(snapshot.validated))
                                StatusRow("Metered", yesNo(snapshot.metered))
                                Button(
                                    onClick = { networkMonitor.refresh() },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text("Refresh status")
                                }
                            }
                        }

                        Card(modifier = Modifier.fillMaxWidth()) {
                            Column(
                                modifier = Modifier.padding(18.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text("What this means", style = MaterialTheme.typography.titleMedium)
                                Text(
                                    "This prototype observes the network Android currently " +
                                        "uses by default. It does not scan private networks, " +
                                        "change your carrier, or combine connections."
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "FBA · local-first · permission-based",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        if (::networkMonitor.isInitialized) {
            networkMonitor.stop()
        }
        super.onDestroy()
    }
}

@androidx.compose.runtime.Composable
private fun StatusRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, style = MaterialTheme.typography.bodyMedium)
        Text(value, style = MaterialTheme.typography.bodyMedium)
    }
}

private fun yesNo(value: Boolean): String = if (value) "Yes" else "No"
