package risk.impact.technical

import risk.IFactor

enum class LossOfAvailability(val weight: Double) : IFactor {
    MINIMAL_SECONDARY_SERVICES_INTERRUPTED(1.0),
    MINIMAL_PRIMARY_SERVICES_INTERRUPTED(5.0),
    EXTENSIVE_SECONDARY_SERVICES_INTERRUPTED(5.0),
    EXTENSIVE_PRIMARY_SERVICES_INTERRUPTED(7.0),
    ALL_SERVICES_COMPLETELY_LOST(9.0);

    override fun weight(): Double = this.weight
}