package br.com.alura.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.alura.financask.R
import br.com.alura.financask.ui.adapters.TransacoesListAdapter
import br.com.alura.financask.ui.model.Tipo
import br.com.alura.financask.ui.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val listaTransacoes = listOf(
            Transacao(BigDecimal(20.50), "Almoço de final de semana",Tipo.DESPESA),
            Transacao(BigDecimal(20.50), tipo = Tipo.RECEITA),
            Transacao(BigDecimal(100), "Economia", Tipo.DESPESA),
            Transacao(BigDecimal(200), tipo = Tipo.DESPESA),
            Transacao(BigDecimal(500), "Premium", Tipo.RECEITA)
        )

        lista_transacoes_listview.adapter = TransacoesListAdapter(this, listaTransacoes)
    }

}