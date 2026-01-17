package com.example.jetnews.brick.demo1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnews.PathIndex.TEST_COMPOSE2
import com.example.jetnews.brick.ServiceCard
import com.therouter.router.Route


@Route(path = TEST_COMPOSE2)
@Composable
fun MoreServicesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(text = "更多服务", style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ServiceCard(title = "仅搬大件", subtitle = "按件计费")
            ServiceCard(title = "仅用人", subtitle = "人工搬运")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ServiceCard(title = "企业搬迁", subtitle = "团队服务")
            ServiceCard(title = "跨城搬家", subtitle = "异地运输")
        }
    }
}
