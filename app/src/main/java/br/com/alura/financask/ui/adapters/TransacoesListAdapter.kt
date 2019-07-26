package br.com.alura.financask.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alura.financask.R
import br.com.alura.financask.extrension.formataParaBrasileiro
import br.com.alura.financask.ui.model.Tipo
import br.com.alura.financask.ui.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*


class TransacoesListAdapter(
    private val context: Context,
    private val listaTransacoes: List<Transacao>
) : BaseAdapter() {
    @SuppressLint("ViewHolder")
    override fun getView(posicao: Int, contentView: View?, viewGroup: ViewGroup?): View {
        val itemList = listaTransacoes[posicao]
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.transacao_item, viewGroup, false)

        view.transacao_valor.text = getValorTransacao(itemList)
        view.transacao_categoria.text = itemList.categoria
        view.transacao_data.text = itemList.data.formataParaBrasileiro()
        view.transacao_icone.setImageDrawable(getTransacaoIcone(itemList.tipo))

        return view
    }

    private fun getValorTransacao(transacao: Transacao): SpannableString {
        val valorString = String.format("R$ %.2f", transacao.valor)
        val spannableString = SpannableString(valorString)
        val color = when (transacao.tipo) {
            Tipo.RECEITA -> ContextCompat.getColor(context, R.color.receita)
            Tipo.DESPESA -> ContextCompat.getColor(context, R.color.despesa)
        }
        spannableString.setSpan(
            ForegroundColorSpan(color),
            0,
            valorString.length,
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }

    private fun getTransacaoIcone(tipo: Tipo): Drawable? {
        return when (tipo) {
            Tipo.RECEITA -> ContextCompat.getDrawable(
                context,
                R.drawable.icone_transacao_item_receita
            )
            Tipo.DESPESA -> ContextCompat.getDrawable(
                context,
                R.drawable.icone_transacao_item_despesa
            )
        }
    }

    override fun getItem(posicao: Int): Transacao {
        return listaTransacoes[posicao]
    }

    override fun getItemId(posicao: Int): Long {
        return listaTransacoes[posicao].hashCode().toLong()
    }

    override fun getCount(): Int {
        return listaTransacoes.size
    }

}