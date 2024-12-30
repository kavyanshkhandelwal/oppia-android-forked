package org.oppia.android.domain.classify.rules.fractioninput

import org.oppia.android.app.model.Fraction
import org.oppia.android.app.model.InteractionObject
import org.oppia.android.domain.classify.ClassificationContext
import org.oppia.android.domain.classify.RuleClassifier
import org.oppia.android.domain.classify.rules.GenericRuleClassifier
import org.oppia.android.domain.classify.rules.RuleClassifierProvider
import org.oppia.android.util.math.toDouble
import javax.inject.Inject

/**
 * Provider for a classifier that determines whether a fraction is greater than another fraction per the fraction input
 * interaction.
 *
 * https://github.com/oppia/oppia/blob/37285a/extensions/interactions/FractionInput/directives/fraction-input-rules.service.ts#L45
 */
// TODO(#1580): Re-restrict access using Bazel visibilities
class FractionInputIsGreaterThanRuleClassifierProvider
  @Inject
  constructor(
    private val classifierFactory: GenericRuleClassifier.Factory,
  ) : RuleClassifierProvider,
    GenericRuleClassifier.SingleInputMatcher<Fraction> {
    override fun createRuleClassifier(): RuleClassifier =
      classifierFactory.createSingleInputClassifier(
        InteractionObject.ObjectTypeCase.FRACTION,
        "f",
        this,
      )

    override fun matches(
      answer: Fraction,
      input: Fraction,
      classificationContext: ClassificationContext,
    ): Boolean = answer.toDouble() > input.toDouble()
  }
