package risk

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
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

internal class ScoreTest {

    @Test
    fun builderTest() {
        val score = Score.Builder()
            .with(SkillLevel.ADVANCED_COMPUTER_USER)
            .with(Motive.HIGH_REWARD)
            .with(Opportunity.FULL_ACCESS_OR_EXPENSIVE_RESOURCES_REQUIRED)
            .with(Size.ANONYMOUS_INTERNET_USERS)
            .with(EaseOfDiscovery.EASY)
            .with(EaseOfExploit.THEORETICAL)
            .with(Awareness.OBVIOUS)
            .with(IntrusionDetection.NOT_LOGGED)
            .with(LossOfConfidentiality.EXTENSIVE_CRITICAL_DATA_DISCLOSED)
            .with(LossOfIntegrity.EXTENSIVE_SERIOUSLY_CORRUPT_DATA)
            .with(LossOfAvailability.MINIMAL_SECONDARY_SERVICES_INTERRUPTED)
            .with(LossOfAccountability.POSSIBLY_TRACEABLE)
            .with(FinancialDamage.BANKRUPTCY)
            .with(ReputationDamage.LOSS_OF_GOODWILL)
            .with(NonCompliance.CLEAR_VIOLATION)
            .with(PrivacyViolation.MILLIONS_OF_PEOPLE)
            .build()

        assertEquals(5.75, score.likelihood())
        assertEquals(Level.MEDIUM, score.likelihoodLevel())

        assertEquals(5.5, score.technical())
        assertEquals(Level.MEDIUM, score.technicalLevel())

        assertEquals(7.0, score.business())
        assertEquals(Level.HIGH, score.businessLevel())
    }
}