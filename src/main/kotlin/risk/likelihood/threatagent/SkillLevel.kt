package risk.likelihood.threatagent

import risk.IFactor

enum class SkillLevel(val weight: Double) : IFactor {
    NO_TECHNICAL_SKILLS(1.0),
    SOME_TECHNICAL_SKILLS(3.0),
    ADVANCED_COMPUTER_USER(5.0),
    NETWORK_AND_PROGRAMMING_SKILLS(6.0),
    SECURITY_PENETRATION_SKILLS(9.0);

    override fun weight(): Double = this.weight
}