from typing import List

__all__ = ('AbilityRecord',)

class AbilityRecord:
    name: str
    url: str

class AbilityDetail:
    ability: AbilityRecord

class Ability:
    abilities: List[AbilityDetail]


