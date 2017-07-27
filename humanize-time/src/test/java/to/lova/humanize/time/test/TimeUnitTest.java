/*-
 * Copyright 2017 Giovanni Lovato
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package to.lova.humanize.time.test;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import to.lova.humanize.time.HumanizeTime;

public class TimeUnitTest {

    private static final ZonedDateTime NOW = ZonedDateTime.now();

    @Test
    public void testNow() {
        String now = HumanizeTime.fromNow(NOW, Locale.ENGLISH);
        Assert.assertEquals("now", now);
    }

    @Test
    public void testSecondsAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.SECONDS), Locale.ENGLISH);
        Assert.assertEquals("2 seconds ago", actual);
    }

    @Test
    public void testMinutesAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.MINUTES), Locale.ENGLISH);
        Assert.assertEquals("2 minutes ago", actual);
    }

    @Test
    public void testHoursAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.HOURS), Locale.ENGLISH);
        Assert.assertEquals("2 hours ago", actual);
    }

    @Test
    public void testDaysAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.DAYS), Locale.ENGLISH);
        Assert.assertEquals("2 days ago", actual);
    }

    @Test
    public void testWeeksAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.WEEKS), Locale.ENGLISH);
        Assert.assertEquals("2 weeks ago", actual);
    }

    @Test
    public void testMonthsAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.MONTHS), Locale.ENGLISH);
        Assert.assertEquals("2 months ago", actual);
    }

    @Test
    public void testYearsAgo() {
        String actual = HumanizeTime.fromNow(NOW.minus(2, ChronoUnit.YEARS), Locale.ENGLISH);
        Assert.assertEquals("2 years ago", actual);
    }

    @Test
    public void testSecondsWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.SECONDS), Locale.ENGLISH);
        Assert.assertEquals("within 2 seconds", actual);
    }

    @Test
    public void testMinutesWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.MINUTES), Locale.ENGLISH);
        Assert.assertEquals("in 2 minutes", actual);
    }

    @Test
    public void testHoursWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.HOURS), Locale.ENGLISH);
        Assert.assertEquals("within 2 hours", actual);
    }

    @Test
    public void testDaysWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.DAYS), Locale.ENGLISH);
        Assert.assertEquals("in 2 days", actual);
    }

    @Test
    public void testWeeksWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.WEEKS), Locale.ENGLISH);
        Assert.assertEquals("within 2 weeks", actual);
    }

    @Test
    public void testMonthsWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.MONTHS), Locale.ENGLISH);
        Assert.assertEquals("in 2 months", actual);
    }

    @Test
    public void testYearsWithin() {
        String actual = HumanizeTime.fromNow(NOW.plus(2, ChronoUnit.YEARS), Locale.ENGLISH);
        Assert.assertEquals("in 2 years", actual);
    }

    @Test
    public void testMissingLocale() {
        String actual = HumanizeTime.fromNow(NOW, Locale.forLanguageTag("xx"));
        Assert.assertEquals("now", actual);
    }

}
