package com.jakewharton.threetenabp.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.threeten.bp.Instant;

import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public final class ExamplesTest {
  @Rule public final ActivityTestRule<Examples> examplesActivity =
      new ActivityTestRule<>(Examples.class);

  /**
   * Assert that ProGuard has run and obfuscated a library type. This implicitly also tests the
   * embedded ProGuard rules in the library are correct since currently ProGuard fails without them.
   */
  @Test public void proguardHappened() {
    Examples activity = examplesActivity.getActivity();
    Instant now = activity.now();
    assertNotEquals("Instant", now.getClass().getSimpleName());
  }
}
