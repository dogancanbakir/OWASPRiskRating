package risk.impact.business

import risk.IFactor

enum class NonCompliance(val weight: Double) : IFactor {
    MINOR_VIOLATION(2.0),
    CLEAR_VIOLATION(5.0),
    HIGH_PROFILE_VIOLATION(7.0);

    override fun weight(): Double = this.weight
}