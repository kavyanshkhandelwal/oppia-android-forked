package org.oppia.android.util.parser.image

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/** Provides image-extraction URL dependencies. */
@Module
class ImageParsingModule {
  @Provides
  @DefaultGcsPrefix
  @Singleton
  fun provideDefaultGcsPrefix(): String = "https://storage.googleapis.com"

  @Provides
  @ImageDownloadUrlTemplate
  @Singleton
  fun provideImageDownloadUrlTemplate(): String = "%s/%s/assets/image/%s"

  @Provides
  @ThumbnailDownloadUrlTemplate
  @Singleton
  fun provideThumbnailDownloadUrlTemplate(): String = "%s/%s/assets/thumbnail/%s"
}
