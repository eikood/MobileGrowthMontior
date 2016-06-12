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
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
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
public class Nexus9Test {

    @Rule
    public ActivityTestRule<MainView> mActivityTestRule = new ActivityTestRule<>(MainView.class);

    @Test
    public void nexus9Test() {
        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText.perform(replaceText("Bauer"));

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText2.perform(replaceText("Lampe"));

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.rb_sex_male), withText("Männlich"),
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
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText5.perform(replaceText("77"));

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText6.perform(replaceText("10"));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        pressBack();

        pressBack();

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText7.perform(replaceText("Neues"));

        appCompatEditText7.perform(pressImeActionButton());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText8.perform(replaceText("Baby"));

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.rb_sex_male), withText("Männlich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.save_profile), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_measurements), withText("Messung"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText9.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText10.perform(replaceText(""));

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText11.perform(replaceText("8"));

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.et_height), isDisplayed()));
        appCompatEditText12.perform(replaceText("68"));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.et_height), withText("68"), isDisplayed()));
        appCompatEditText13.perform(click());

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView3.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_measurements), withText("Messung"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText14.perform(click());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText15.perform(replaceText("105"));

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText16.perform(replaceText(""));

        pressBack();

        pressBack();

        pressBack();

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText17.perform(replaceText("Dickes"));

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText18.perform(replaceText("Kind"));

        ViewInteraction appCompatRadioButton3 = onView(
                allOf(withId(R.id.rb_sex_male), withText("Männlich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton3.perform(click());

        pressBack();

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.save_profile), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction recyclerView4 = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView4.perform(actionOnItemAtPosition(2, click()));

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btn_measurements), withText("Messung"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText19.perform(click());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText20.perform(replaceText("105"));

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText21.perform(replaceText("17.5"));

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton7.perform(click());

        pressBack();

        pressBack();

        pressBack();

    }
}
