package org.oppia.android.domain.classify.rules.numericinput

import org.oppia.android.app.model.InteractionObject
import org.oppia.android.domain.classify.ClassificationContext
import org.oppia.android.domain.classify.RuleClassifier
import org.oppia.android.domain.classify.rules.GenericRuleClassifier
import org.oppia.android.domain.classify.rules.RuleClassifierProvider
import org.oppia.android.util.math.isApproximatelyEqualTo
import javax.inject.Inject

/**
 * Provider for a classifier that determines whether two integers are equal per the numeric input interaction.
 *
 * https://github.com/oppia/oppia/blob/37285a/extensions/interactions/NumericInput/directives/numeric-input-rules.service.ts#L21
 */
// TODO(#1580): Re-restrict access using Bazel visibilities
class NumericInputEqualsRuleClassifierProvider
  @Inject
  constructor(
    private val classifierFactory: GenericRuleClassifier.Factory,
  ) : RuleClassifierProvider,
    GenericRuleClassifier.SingleInputMatcher<Double> {
    override fun createRuleClassifier(): RuleClassifier =
      classifierFactory.createSingleInputClassifier(
        InteractionObject.ObjectTypeCase.REAL,
        "x",
        this,
      )

    override fun matches(
      answer: Double,
      input: Double,
      classificationContext: ClassificationContext,
    ): Boolean = input.isApproximatelyEqualTo(answer)
  }
