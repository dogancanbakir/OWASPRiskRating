package risk.impact.technical

import risk.IFactor

enum class LossOfConfidentiality(val weight: Double) : IFactor {
    MINIMAL_NON_SENSITIVE_DATA_DISCLOSED(2.0),
    MINIMAL_CRITICAL_DATA_DISCLOSED(6.0),
    EXTENSIVE_NON_SENSITIVE_DATA_DISCLOSED(6.0),
    EXTENSIVE_CRITICAL_DATA_DISCLOSED (7.0),
    ALL_DATA_DISCLOSED(9.0);

    override fun weight(): Double = this.weight
}