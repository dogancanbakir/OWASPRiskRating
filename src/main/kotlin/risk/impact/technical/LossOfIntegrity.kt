package risk.impact.technical

import risk.IFactor

enum class LossOfIntegrity(val weight: Double) : IFactor {
    MINIMAL_SLIGHTLY_CORRUPT_DATA(1.0),
    MINIMAL_SERIOUSLY_CORRUPT_DATA(3.0),
    EXTENSIVE_SLIGHTLY_CORRUPT_DATA(5.0),
    EXTENSIVE_SERIOUSLY_CORRUPT_DATA(7.0),
    ALL_DATA_TOTALLY_CORRUPT(9.0);

    override fun weight(): Double = this.weight
}