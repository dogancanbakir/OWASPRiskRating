package risk.impact.business

import risk.IFactor

enum class FinancialDamage(val weight: Double) : IFactor {
    LESS_THAN_THE_COST_TO_FIX_THE_VULNERABILITY(1.0),
    MINOR_EFFECT_ON_ANNUAL_PROFIT(3.0),
    SIGNIFICANT_EFFECT_ON_ANNUAL_PROFIT(7.0),
    BANKRUPTCY(9.0);

    override fun weight(): Double = this.weight
}