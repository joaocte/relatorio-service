package br.com.curso.consumer

import br.com.curso.application.usecase.realizarVenda.RealizarVeiculoUseCase
import br.com.curso.extension.toDomain
import br.com.curso.infrastructure.model.VendaModel
import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class VendaConsumer(
    private val objectMapper: ObjectMapper,
    private val realizarVeiculoUseCase: RealizarVeiculoUseCase,
) {

    @Topic("ms-vendas")
    fun consumer(eventId: String, event: String) {
        var venda = objectMapper.readValue(event, VendaModel::class.java)

        realizarVeiculoUseCase.execute(venda.toDomain())
    }
}