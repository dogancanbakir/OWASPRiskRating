package risk.likelihood.threatagent

import risk.IFactor

enum class Size(val weight: Double) : IFactor {
    DEVELOPERS(2.0),
    SYSTEM_ADMINISTRATORS(2.0),
    INTRANET_USERS(4.0),
    PARTNERS(5.0),
    AUTHENTICATED_USERS(6.0),
    ANONYMOUS_INTERNET_USERS(9.0);

    override fun weight(): Double = this.weight
}