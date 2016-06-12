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
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Nexus7Test {

    @Rule
    public ActivityTestRule<MainView> mActivityTestRule = new ActivityTestRule<>(MainView.class);

    @Test
    public void generalTest1206() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(android.R.id.button1), withText("Ja"),
                        withParent(allOf(withId(R.id.buttonPanel),
                                withParent(withId(R.id.parentPanel)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText2.perform(replaceText("Julian"));

        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText3.perform(replaceText("Braasch"));

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.rb_sex_male), withText("Männlich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction numberPicker = onView(
                allOf(withClassName(is("android.widget.NumberPicker")),
                        withParent(withClassName(is("android.widget.LinearLayout"))),
                        isDisplayed()));
        numberPicker.perform(click());

        ViewInteraction customEditText = onView(
                allOf(withClassName(is("android.widget.NumberPicker$CustomEditText")), withText("01"),
                        withParent(allOf(withClassName(is("android.widget.NumberPicker")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        customEditText.perform(replaceText("1"));

        customEditText.perform(pressImeActionButton());

        ViewInteraction customEditText2 = onView(
                allOf(withClassName(is("android.widget.NumberPicker$CustomEditText")), withText("Jan."),
                        withParent(allOf(withClassName(is("android.widget.NumberPicker")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        customEditText2.perform(replaceText(""));

        ViewInteraction numberPicker2 = onView(
                allOf(withClassName(is("android.widget.NumberPicker")),
                        withParent(withClassName(is("android.widget.LinearLayout"))),
                        isDisplayed()));
        numberPicker2.perform(click());

        ViewInteraction customEditText3 = onView(
                allOf(withClassName(is("android.widget.NumberPicker$CustomEditText")), withText("1"),
                        withParent(allOf(withClassName(is("android.widget.NumberPicker")),
                                withParent(withClassName(is("android.widget.LinearLayout"))))),
                        isDisplayed()));
        customEditText3.perform(replaceText("17"));

        customEditText3.perform(pressImeActionButton());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.save_profile), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_camera), withText("Foto"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText4.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.et_heightReference), withText("10.0"), isDisplayed()));
        appCompatEditText5.perform(replaceText("17.75"));

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.measure_start), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_capture), withText("Aufnahme"),
                        withParent(allOf(withId(R.id.innerRelativeLayout),
                                withParent(withId(R.id.rl_NativeCam)))),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText6.perform(replaceText("62.7"));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton4.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_gallery), withText("Galerie"), isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction imageView = onView(
                allOf(withClassName(is("android.widget.ImageView")),
                        withParent(allOf(withId(R.id.gridview),
                                withParent(withId(R.id.container)))),
                        isDisplayed()));
        imageView.perform(click());

        pressBack();

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btn_measurements), withText("Messung"), isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.et_height), withText("49.5"), isDisplayed()));
        appCompatEditText7.perform(click());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.et_height), withText("49.5"), isDisplayed()));
        appCompatEditText8.perform(replaceText("180"));

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.et_weight), withText("62.7"), isDisplayed()));
        appCompatEditText9.perform(replaceText("56"));

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton8.perform(click());

        appCompatButton8.perform(pressImeActionButton());

        pressBack();

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btn_graphs), withText("Auswertung"), isDisplayed()));
        appCompatButton9.perform(click());

        pressBack();

        pressBack();

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab), isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText10.perform(click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.et_firstname), isDisplayed()));
        appCompatEditText11.perform(replaceText("Jacky"));

        appCompatEditText11.perform(pressImeActionButton());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.et_lastname), isDisplayed()));
        appCompatEditText12.perform(replaceText("Franßen"));

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.rb_sex_female), withText("Weiblich"),
                        withParent(withId(R.id.rg_gender)),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        ViewInteraction actionMenuItemView3 = onView(
                allOf(withId(R.id.save_profile), withText("Speichern"), withContentDescription("Speichern"), isDisplayed()));
        actionMenuItemView3.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.rv_profileList), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btn_measurements), withText("Messung"), isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText13.perform(click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText14.perform(click());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.et_height), withText("0.0"), isDisplayed()));
        appCompatEditText15.perform(replaceText("172"));

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.et_weight), withText("0.0"), isDisplayed()));
        appCompatEditText16.perform(replaceText("62.7"));

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btn_enter_for_bmi), withText("Enter"), isDisplayed()));
        appCompatButton11.perform(click());

        pressBack();

        pressBack();

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btn_graphs), withText("Auswertung"), isDisplayed()));
        appCompatButton12.perform(click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.btn_graphs), withText("Auswertung"), isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.btn_graphs), withText("Auswertung"), isDisplayed()));
        appCompatButton14.perform(click());

    }
}
