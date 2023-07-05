package kg.vohkysan.home_work7_1.presentation.ui.fragments.family.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.vohkysan.home_work7_1.databinding.ItemFamilyBinding
import kg.vohkysan.home_work7_1.domain.models.Family

class FamilyAdapter(
    private val onClick: (family : Family) -> Unit
) : Adapter<FamilyAdapter.FamilyViewHolder>() {
    private val familyList = arrayListOf<Family>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        return FamilyViewHolder(
            ItemFamilyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun addTasks(family: List<Family>) {
        familyList.clear()
        familyList.addAll(family)
        notifyDataSetChanged()
    }

    fun getFamily(position : Int): Family{
        return familyList[position]
    }

    override fun getItemCount(): Int = familyList.size

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.onBind(family = familyList[position])
    }

    inner class FamilyViewHolder(private val binding: ItemFamilyBinding) :
        ViewHolder(binding.root) {

        fun onBind(family: Family) {
            with(binding){
                tvName.text = family.name
                tvMother.text = family.mother
                tvFather.text = family.father
            }
            itemView.setOnClickListener {
                onClick(getFamily(adapterPosition))
            }
        }
    }
}