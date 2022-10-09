package risk

import risk.impact.business.FinancialDamage
import risk.impact.business.NonCompliance
import risk.impact.business.PrivacyViolation
import risk.impact.business.ReputationDamage
import risk.impact.technical.LossOfAccountability
import risk.impact.technical.LossOfAvailability
import risk.impact.technical.LossOfConfidentiality
import risk.impact.technical.LossOfIntegrity
import risk.likelihood.threatagent.Motive
import risk.likelihood.threatagent.Opportunity
import risk.likelihood.threatagent.Size
import risk.likelihood.threatagent.SkillLevel
import risk.likelihood.vulnerability.Awareness
import risk.likelihood.vulnerability.EaseOfDiscovery
import risk.likelihood.vulnerability.EaseOfExploit
import risk.likelihood.vulnerability.IntrusionDetection

class Score private constructor(
    private val likelihood: Double,
    private val technical: Double,
    private val business: Double
) {
    fun likelihood(): Double = this.likelihood
    fun technical(): Double = this.technical
    fun business(): Double = this.business

    fun likelihoodLevel(): Level = level(this.likelihood)
    fun technicalLevel(): Level = level(this.technical)
    fun businessLevel(): Level = level(this.business)

    private fun level(score: Double): Level = when (score) {
        in 0.0..3.0 -> Level.LOW
        in 3.0..6.0 -> Level.MEDIUM
        in 6.0..9.0 -> Level.HIGH
        else -> Level.NONE
    }

    data class Builder(
        var skillLevel: SkillLevel? = null,
        var motive: Motive? = null,
        var opportunity: Opportunity? = null,
        var size: Size? = null,
        var easeOfDiscovery: EaseOfDiscovery? = null,
        var easeOfExploit: EaseOfExploit? = null,
        var awareness: Awareness? = null,
        var intrusionDetection: IntrusionDetection? = null,
        var lossOfConfidentiality: LossOfConfidentiality? = null,
        var lossOfIntegrity: LossOfIntegrity? = null,
        var lossOfAvailability: LossOfAvailability? = null,
        var lossOfAccountability: LossOfAccountability? = null,
        var financialDamage: FinancialDamage? = null,
        var reputationDamage: ReputationDamage? = null,
        var nonCompliance: NonCompliance? = null,
        var privacyViolation: PrivacyViolation? = null
    ) {
        fun with(skillLevel: SkillLevel) = apply { this.skillLevel = skillLevel }
        fun with(motive: Motive) = apply { this.motive = motive }
        fun with(opportunity: Opportunity) = apply { this.opportunity = opportunity }
        fun with(size: Size) = apply { this.size = size }
        fun with(easeOfDiscovery: EaseOfDiscovery) = apply { this.easeOfDiscovery = easeOfDiscovery }
        fun with(easeOfExploit: EaseOfExploit) = apply { this.easeOfExploit = easeOfExploit }
        fun with(awareness: Awareness) = apply { this.awareness = awareness }
        fun with(intrusionDetection: IntrusionDetection) = apply { this.intrusionDetection = intrusionDetection }
        fun with(lossOfConfidentiality: LossOfConfidentiality) =
            apply { this.lossOfConfidentiality = lossOfConfidentiality }

        fun with(lossOfIntegrity: LossOfIntegrity) = apply { this.lossOfIntegrity = lossOfIntegrity }
        fun with(lossOfAvailability: LossOfAvailability) = apply { this.lossOfAvailability = lossOfAvailability }
        fun with(lossOfAccountability: LossOfAccountability) =
            apply { this.lossOfAccountability = lossOfAccountability }

        fun with(financialDamage: FinancialDamage) = apply { this.financialDamage = financialDamage }
        fun with(reputationDamage: ReputationDamage) = apply { this.reputationDamage = reputationDamage }
        fun with(nonCompliance: NonCompliance) = apply { this.nonCompliance = nonCompliance }
        fun with(privacyViolation: PrivacyViolation) = apply { this.privacyViolation = privacyViolation }


        fun build() = Score(
            ((this.skillLevel!!.weight() + this.motive!!.weight() + this.opportunity!!.weight() + this.size!!.weight()
                    + this.easeOfDiscovery!!.weight() + this.easeOfExploit!!.weight() + this.awareness!!.weight() + this.intrusionDetection!!.weight()) / 8),
            ((this.lossOfConfidentiality!!.weight() + this.lossOfIntegrity!!.weight() + this.lossOfAvailability!!.weight() + this.lossOfAccountability!!.weight()) / 4),
            ((this.financialDamage!!.weight() + this.reputationDamage!!.weight() + this.nonCompliance!!.weight() + this.privacyViolation!!.weight()) / 4)
        )
    }
}