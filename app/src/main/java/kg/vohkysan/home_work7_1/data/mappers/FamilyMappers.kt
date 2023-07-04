package kg.vohkysan.home_work7_1.data.mappers

import kg.vohkysan.home_work7_1.data.models.FamilyEntity
import kg.vohkysan.home_work7_1.domain.models.Family

fun Family.toEntity() : FamilyEntity{
    return FamilyEntity(id = id, name = name, mother = mother, father = father)
}

fun FamilyEntity.toFamily() : Family{
    return Family(id = id, name = name, mother = mother, father = father)
}