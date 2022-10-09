package risk.impact.technical

import risk.IFactor

enum class LossOfAccountability(val weight: Double) : IFactor {
    FULLY_TRACEABLE(1.0),
    POSSIBLY_TRACEABLE(7.0),
    COMPLETELY_ANONYMOUS(9.0);

    override fun weight(): Double = this.weight
}