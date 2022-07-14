package br.com.curso.application.usecase.realizarVenda

import br.com.curso.application.out.RealizarVendaCommandResponse
import br.com.curso.domain.Venda

interface IRealizarVendaUseCase {
    fun execute(venda: Venda): RealizarVendaCommandResponse
}