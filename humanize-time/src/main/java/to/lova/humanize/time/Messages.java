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
package to.lova.humanize.time;

import com.vityuk.ginger.Localizable;
import com.vityuk.ginger.PluralCount;

/**
 * {@link Localizable} interface to obtain humanized relative-time messages.
 *
 * @author Giovanni Lovato
 */
public interface Messages extends Localizable {

    /**
     * Returns a humanized message for "now".
     *
     * @return the humanized message for "now"
     */
    String now();

    /**
     * Returns a humanized message for "years ago".
     *
     * @param years the number of years
     * @return the humanized message for "years ago"
     */
    String yearsAgo(@PluralCount int years);

    /**
     * Returns a humanized message for "months ago".
     *
     * @param months the number of months
     * @return the humanized message for "months ago"
     */
    String monthsAgo(@PluralCount int months);

    /**
     * Returns a humanized message for "weeks ago".
     *
     * @param weeks the number of weeks
     * @return the humanized message for "weeks ago"
     */
    String weeksAgo(@PluralCount int weeks);

    /**
     * Returns a humanized message for "days ago".
     *
     * @param days the number of days
     * @return the humanized message for "days ago"
     */
    String daysAgo(@PluralCount int days);

    /**
     * Returns a humanized message for "hours ago".
     *
     * @param hours the number of hours
     * @return the humanized message for "hours ago"
     */
    String hoursAgo(@PluralCount int hours);

    /**
     * Returns a humanized message for "minutes ago".
     *
     * @param minutes the number of minutes
     * @return the humanized message for "minutes ago"
     */
    String minutesAgo(@PluralCount int minutes);

    /**
     * Returns a humanized message for "seconds ago".
     *
     * @param seconds the number of seconds
     * @return the humanized message for "seconds ago"
     */
    String secondsAgo(@PluralCount int seconds);

    /**
     * Returns a humanized message for "years within".
     *
     * @param years the number of years
     * @return the humanized message for "years within"
     */
    String yearsWithin(@PluralCount int years);

    /**
     * Returns a humanized message for "months ago".
     *
     * @param months the number of months
     * @return the humanized message for "months within"
     */
    String monthsWithin(@PluralCount int months);

    /**
     * Returns a humanized message for "weeks within".
     *
     * @param weeks the number of weeks
     * @return the humanized message for "weeks within"
     */
    String weeksWithin(@PluralCount int weeks);

    /**
     * Returns a humanized message for "days within".
     *
     * @param days the number of days
     * @return the humanized message for "days within"
     */
    String daysWithin(@PluralCount int days);

    /**
     * Returns a humanized message for "hours within".
     *
     * @param hours the number of hours
     * @return the humanized message for "hours within"
     */
    String hoursWithin(@PluralCount int hours);

    /**
     * Returns a humanized message for "minutes within".
     *
     * @param minutes the number of minutes
     * @return the humanized message for "minutes within"
     */
    String minutesWithin(@PluralCount int minutes);

    /**
     * Returns a humanized message for "seconds within".
     *
     * @param seconds the number of seconds
     * @return the humanized message for "seconds within"
     */
    String secondsWithin(@PluralCount int seconds);

}
