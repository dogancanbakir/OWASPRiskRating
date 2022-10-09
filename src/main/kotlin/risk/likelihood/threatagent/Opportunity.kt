package risk.likelihood.threatagent

import risk.IFactor

enum class Opportunity(val weight: Double) : IFactor {
    FULL_ACCESS_OR_EXPENSIVE_RESOURCES_REQUIRED(0.0),
    SPECIAL_ACCESS_OR_RESOURCES_REQUIRED(4.0),
    SOME_ACCESS_OR_RESOURCES_REQUIRED(7.0),
    NO_ACCESS_OR_RESOURCES_REQUIRED(9.0);

    override fun weight(): Double = this.weight
}