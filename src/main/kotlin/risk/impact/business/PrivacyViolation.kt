package risk.impact.business

import risk.IFactor

enum class PrivacyViolation(val weight: Double) :IFactor {
    ONE_INDIVIDUAL(3.0),
    HUNDREDS_OF_PEOPLE(5.0),
    THOUSANDS_OF_PEOPLE(7.0),
    MILLIONS_OF_PEOPLE(9.0);

    override fun weight(): Double = this.weight
}