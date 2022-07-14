package br.com.curso.application.usecase.realizarVenda

import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.domain.Venda
import br.com.curso.exception.custoException.AlreadyRegisteredException
import br.com.curso.extension.toModel
import br.com.curso.infrastructure.IVendaRepository
import jakarta.inject.Singleton

@Singleton
class RealizarVeiculoUseCase(
    private val repository: IVendaRepository,

    ) : IRealizarVendaUseCase {
    override fun execute(venda: Venda): RealizarVendaCommandResponse {


        var vendaModel = venda.toModel()


        val vendaJaCadastrada = this.repository.existsById(vendaModel.id)

        if (vendaJaCadastrada) {
            throw AlreadyRegisteredException()
        }


        val vendaDatabase = this.repository.save(vendaModel)


        return RealizarVendaCommandResponse(
            vendaDatabase.id!!,
            vendaDatabase.nomeCliente,
            vendaDatabase.parcelas.count().toLong(),
            vendaDatabase.valor,
            venda.parcelas
        )
    }
}
