package risk.impact.business

import risk.IFactor

enum class ReputationDamage(val weight: Double) : IFactor {
    MINIMAL_DAMAGE(1.0),
    LOSS_OF_MAJOR_ACCOUNTS(4.0),
    LOSS_OF_GOODWILL(5.0),
    BRAND_DAMAGE(9.0);

    override fun weight(): Double = this.weight
}