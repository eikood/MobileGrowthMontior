package de.hs_mannheim.planb.mobilegrowthmonitor;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Nexus5xTest1 {

    @Rule
    public ActivityTestRule<MainView> mActivityTestRule = new ActivityTestRule<>(MainView.class);

    @Test
    public void nexus5xTest1() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(android.R.id.button1), withText("Yes"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button2), withText("No"),
                        withParent(allOf(withClassName(is("com.android.internal.widget.ButtonBarLayout")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText.perform(replaceText("T"));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText2.perform(replaceText("Profil"));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.et_firstname), withText("T"), isDisplayed()));
        appCompatEditText3.perform(replaceText("Test"));

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.rb_sex_male), withText("Männlich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.rb_sex_female), withText("Weiblich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        pressBack();

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.save_profile), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_camera), withText("Foto"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText5.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText6.perform(replaceText("31"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.et_weightMeasurement), withText("0.0"), isDisplayed()));
        appCompatEditText7.perform(replaceText("0."));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_camera), withText("Foto"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText8.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText9.perform(replaceText("31"));

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.et_weightMeasurement), withText("0.0"), isDisplayed()));
        appCompatEditText10.perform(replaceText("62.7"));

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.measure_start), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_capture), withText("Aufnahme"),
                        withParent(allOf(withId(R.id.innerRelativeLayout),
                                withParent(withId(R.id.rl_NativeCam)))),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btn_undo), withText("Undo"), isDisplayed()));
        appCompatButton6.perform(click());

    }
}
