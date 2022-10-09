package risk.likelihood.threatagent

import risk.IFactor

enum class Motive(val weight: Double) : IFactor {
    LOW_OR_NO_REWARD(1.0),
    POSSIBLE_REWARD(4.0),
    HIGH_REWARD(9.0);

    override fun weight(): Double = this.weight
}