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
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MotorolaETest {

    @Rule
    public ActivityTestRule<MainView> mActivityTestRule = new ActivityTestRule<>(MainView.class);

    @Test
    public void motorolaETest() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText.perform(replaceText("Hallo"));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText2.perform(replaceText("Kadtoffel"));

        pressBack();

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.rb_sex_female), withText("Weiblich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.save_profile), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_measurements), withText("Messung"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText3.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText4.perform(replaceText("110"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText5.perform(replaceText("20"));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton3.perform(click());

        pressBack();

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_camera), withText("Foto"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText7.perform(replaceText("31"));

        pressBack();

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.measure_start), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_capture), withText("Aufnahme"),
                        withParent(allOf(withId(R.id.innerRelativeLayout),
                                withParent(withId(R.id.rl_NativeCam)))),
                        isDisplayed()));
        appCompatButton5.perform(click());

        pressBack();

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.measure_start), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btn_capture), withText("Aufnahme"),
                        withParent(allOf(withId(R.id.innerRelativeLayout),
                                withParent(withId(R.id.rl_NativeCam)))),
                        isDisplayed()));
        appCompatButton6.perform(click());

        pressBack();

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btn_graphs), withText("Auswertung"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btn_gallery), withText("Galerie"), isDisplayed()));
        appCompatButton8.perform(click());

        pressBack();

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btn_graphs), withText("Auswertung"), isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btn_export), withText("Export"), isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.bt_confirm), withText("Ja"), isDisplayed()));
        appCompatButton11.perform(click());

    }
}
