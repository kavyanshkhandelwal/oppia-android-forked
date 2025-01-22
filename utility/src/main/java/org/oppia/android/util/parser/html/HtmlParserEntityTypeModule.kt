package org.oppia.android.util.parser.html

import dagger.Module
import dagger.Provides

/** Provides Html parsing entity type dependencies. */
@Module
class HtmlParserEntityTypeModule {
  @Provides
  @ExplorationHtmlParserEntityType
  fun provideExplorationHtmlParserEntityType(): String = "exploration"

  @Provides
  @ConceptCardHtmlParserEntityType
  fun provideConceptCardHtmlParserEntityType(): String = "skill"

  @Provides
  @ClassroomHtmlParserEntityType
  fun provideClassroomCardHtmlParserEntityType(): String {
    return "classroom"
  }

  @Provides
  @TopicHtmlParserEntityType
  fun provideReviewCardHtmlParserEntityType(): String = "topic"

  @Provides
  @StoryHtmlParserEntityType
  fun provideStoryHtmlParserEntityType(): String = "story"
}
