package br.com.curso.extension

import br.com.curso.domain.Parcela
import br.com.curso.domain.Veiculo
import br.com.curso.domain.Venda
import br.com.curso.infrastructure.model.ParcelaModel
import br.com.curso.infrastructure.model.VeiculoModel
import br.com.curso.infrastructure.model.VendaModel


fun Venda.toModel(): VendaModel {
    return VendaModel(this.id, this.nomeCliente, this.veiculo.toModel(), this.valor, this.parcelas.map { it.toModel() })
}

fun VendaModel.toDomain(): Venda {
    return Venda(this.id, this.nomeCliente, this.veiculo.toDomain(), this.valor, this.parcelas.map { it.toDomain() })
}

fun Parcela.toModel(): ParcelaModel {
    return ParcelaModel(this.numeroParcela, this.valorParcela, this.dataVencimento)
}


fun ParcelaModel.toDomain(): Parcela {
    return Parcela(this.numeroParcela, this.valorParcela, this.dataVencimento)
}

fun Veiculo.toModel(): VeiculoModel {
    return VeiculoModel(this.id, this.modelo, this.marca, this.anoFabricacao, this.anoModelo, this.placa, this.valor)
}

fun VeiculoModel.toDomain(): Veiculo {
    return Veiculo(this.id, this.modelo, this.marca, this.anoFabricacao, this.anoModelo, this.placa, this.valor)
}

