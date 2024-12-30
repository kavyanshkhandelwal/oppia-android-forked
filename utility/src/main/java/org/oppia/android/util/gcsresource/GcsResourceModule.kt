package org.oppia.android.util.gcsresource

import dagger.Module
import dagger.Provides

/** Provides GCS resource bucket names. */
@Module
class GcsResourceModule {
  @Provides
  @DefaultResourceBucketName
  fun provideDefaultGcsResource(): String = "oppiaserver-resources"

  @Provides
  @QuestionResourceBucketName
  fun provideQuestionResourceBucketName(): String = "oppiatestserver-resources"
}
