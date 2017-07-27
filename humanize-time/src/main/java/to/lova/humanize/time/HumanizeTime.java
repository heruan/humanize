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

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Locale;

import com.vityuk.ginger.LocaleResolver;
import com.vityuk.ginger.LocalizationBuilder;
import com.vityuk.ginger.provider.ResourceNotFoundException;

/**
 * Class to produce humanized messages about time.
 *
 * @author Giovanni Lovato
 */
public class HumanizeTime implements LocaleResolver {

    /**
     * Returns a humanized message for the relative time between now and {@code temporal}.
     *
     * @param temporal the reference time
     * @return the humanized time
     */
    public static String fromNow(Temporal temporal) {
        return fromNow(temporal, Locale::getDefault);
    }

    /**
     * Returns a humanized message for the relative time between now and {@code temporal}.
     *
     * @param temporal the reference time
     * @param locale the locale used to localize the message
     * @return the humanized time
     */
    public static String fromNow(Temporal temporal, Locale locale) {
        return fromNow(temporal, () -> locale);
    }

    /**
     * Returns a humanized message for the relative time between now and {@code temporal}.
     *
     * @param temporal the reference time
     * @param localeResolver the resolver for the locale used to localize the message
     * @return the humanized time
     */
    public static String fromNow(Temporal temporal, LocaleResolver localeResolver) {
        return new HumanizeTime(temporal, localeResolver).fromNow();
    }

    private final Temporal temporal;

    private final Messages messages;

    private final LocaleResolver localeResolver;

    /**
     * Constructs an instance of {@code HumanizeTime} relative to the time of construction.
     */
    public HumanizeTime() {
        this(ZonedDateTime.now());
    }

    /**
     * Constructs an instance of {@code HumanizeTime}.
     *
     * @param temporal the reference time
     */
    public HumanizeTime(final Temporal temporal) {
        this(temporal, Locale::getDefault);
    }

    /**
     * Constructs an instance of {@code HumanizeTime} with a specified {@link Locale}.
     *
     * @param temporal the reference time
     * @param locale the locale used to localize the message
     */
    public HumanizeTime(final Temporal temporal, final Locale locale) {
        this(temporal, () -> locale);
    }

    /**
     * Constructs an instance of {@code HumanizeTime} with a {@link LocaleResolver} which may be expressed by a lambda,
     * e.g. {@code new HumanizeTime(temporal, () -> Locale.ENGLISH}.
     *
     * @param temporal the reference time
     * @param localeResolver the resolver for the locale used to localize the message
     */
    public HumanizeTime(final Temporal temporal, final LocaleResolver localeResolver) {
        this.temporal = temporal;
        this.localeResolver = localeResolver;
        this.messages = new LocalizationBuilder().withLocaleResolver(this.localeResolver)
                .withResourceLocation("classpath:messages.properties").build().getLocalizable(Messages.class);
    }

    /**
     * Returns a humanized message for the relative time between now and the reference temporal, i.e. the one used to
     * construct this instance of {@code HumanizeTime}).
     *
     * @return the humanized time
     */
    public String fromNow() {
        return this.from(ZonedDateTime.now());
    }

    /**
     * Returns a humanized message for the relative time between {@code temporal} and the reference temporal, i.e. the
     * one used to construct this instance of {@code HumanizeTime}.
     *
     * @param temporal the reference time
     * @return the humanized tme
     */
    public String from(final Temporal temporal) {
        int years = (int) ChronoUnit.YEARS.between(this.temporal, temporal);
        int months = (int) ChronoUnit.MONTHS.between(this.temporal, temporal);
        int weeks = (int) ChronoUnit.WEEKS.between(this.temporal, temporal);
        int days = (int) ChronoUnit.DAYS.between(this.temporal, temporal);
        int hours = (int) ChronoUnit.HOURS.between(this.temporal, temporal);
        int minutes = (int) ChronoUnit.MINUTES.between(this.temporal, temporal);
        int seconds = (int) ChronoUnit.SECONDS.between(this.temporal, temporal);

        try {
            if (years > 0) {
                return this.messages.yearsAgo(years);
            } else if (months > 0) {
                return this.messages.monthsAgo(months);
            } else if (weeks > 0) {
                return this.messages.weeksAgo(weeks);
            } else if (days > 0) {
                return this.messages.daysAgo(days);
            } else if (hours > 0) {
                return this.messages.hoursAgo(hours);
            } else if (minutes > 0) {
                return this.messages.minutesAgo(minutes);
            } else if (seconds > 0) {
                return this.messages.secondsAgo(seconds);
            } else if (years < 0) {
                return this.messages.yearsWithin(-years);
            } else if (months < 0) {
                return this.messages.monthsWithin(-months);
            } else if (weeks < 0) {
                return this.messages.weeksWithin(-weeks);
            } else if (days < 0) {
                return this.messages.daysWithin(-days);
            } else if (hours < 0) {
                return this.messages.hoursWithin(-hours);
            } else if (minutes < 0) {
                return this.messages.minutesWithin(-minutes);
            } else if (seconds < 0) {
                return this.messages.secondsWithin(-seconds);
            } else {
                return this.messages.now();
            }
        } catch (ResourceNotFoundException resourceNotFoundException) {
            return new HumanizeTime(this.temporal, Locale.ENGLISH).from(temporal);
        }
    }

    @Override
    public Locale getLocale() {
        return this.localeResolver.getLocale();
    }

}
