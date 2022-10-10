# OWASP Risk Rating library (experimental-library)

### The OWASP Risk Rating Methodology
Discovering vulnerabilities is important, but being able to estimate the associated risk to the business is just as important. Early in the life cycle, one may identify security concerns in the architecture or design by using threat modeling. Later, one may find security issues using code review or penetration testing. Or problems may not be discovered until the application is in production and is actually compromised.

By following the approach here, it is possible to estimate the severity of all of these risks to the business and make an informed decision about what to do about those risks. Having a system in place for rating risks will save time and eliminate arguing about priorities. This system will help to ensure that the business doesn't get distracted by minor risks while ignoring more serious risks that are less well understood.

Ideally there would be a universal risk rating system that would accurately estimate all risks for all organizations. But a vulnerability that is critical to one organization may not be very important to another. So a basic framework is presented here that should be customized for the particular organization.

The authors have tried hard to make this model simple to use, while keeping enough detail for accurate risk estimates to be made. Please reference the section below on customization for more information about tailoring the model for use in a specific organization.

For more information please see: [OWASP Risk Rating Methodology](https://wiki.owasp.org/index.php/OWASP_Risk_Rating_Methodology)

### Usage

```kotlin
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

val likelihoodScore = score.likelihood()
val likelihoodLevel = score.likelihoodLevel()
        
val technicalScore = score.technical()
val technicalLevel = score.technicalLevel()

val businessScore = score.business()
val businessLevel = score.businessLevel()
```

### Java implementation
[owasp-risk-rating-calculator](https://github.com/stevespringett/owasp-risk-rating-calculator)
