package org.oppia.android.domain.classify.rules.fractioninput

import org.oppia.android.app.model.Fraction
import org.oppia.android.app.model.InteractionObject
import org.oppia.android.domain.classify.ClassificationContext
import org.oppia.android.domain.classify.RuleClassifier
import org.oppia.android.domain.classify.rules.GenericRuleClassifier
import org.oppia.android.domain.classify.rules.RuleClassifierProvider
import javax.inject.Inject

/**
 * Provider for a classifier that determines whether a fraction has a fractional part exactly equal to the fractional
 * part of an input fraction per the fraction input interaction.
 *
 * https://github.com/oppia/oppia/blob/37285a/extensions/interactions/FractionInput/directives/fraction-input-rules.service.ts#L61
 */
// TODO(#1580): Re-restrict access using Bazel visibilities
class FractionInputHasFractionalPartExactlyEqualToRuleClassifierProvider
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
    ): Boolean = answer.numerator == input.numerator && answer.denominator == input.denominator
  }
