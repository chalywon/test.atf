// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.openqa.selenium.thoughtworks.webdriven;

import org.openqa.selenium.thoughtworks.webdriven.commands.GetValue;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAttribute;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetElementHeight;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetElementIndex;
import org.openqa.selenium.thoughtworks.webdriven.commands.MouseEvent;
import org.openqa.selenium.thoughtworks.webdriven.commands.SelectWindow;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAttributeFromAllWindows;
import org.openqa.selenium.thoughtworks.webdriven.commands.KeyState;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetText;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsElementPresent;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAllWindowTitles;
import org.openqa.selenium.thoughtworks.webdriven.commands.DoubleClick;
import org.openqa.selenium.thoughtworks.webdriven.commands.KeyEvent;
import org.openqa.selenium.thoughtworks.webdriven.commands.GoBack;
import org.openqa.selenium.thoughtworks.webdriven.commands.Refresh;
import org.openqa.selenium.thoughtworks.webdriven.commands.WindowMaximize;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetConfirmation;
import org.openqa.selenium.thoughtworks.webdriven.commands.DeleteCookie;
import org.openqa.selenium.thoughtworks.webdriven.commands.AltKeyDown;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsAlertPresent;
import org.openqa.selenium.thoughtworks.webdriven.commands.DeselectPopUp;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAllButtons;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetTitle;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAllLinks;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetHtmlSource;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetBodyText;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetEval;
import org.openqa.selenium.thoughtworks.webdriven.commands.KeyPressNative;
import org.openqa.selenium.thoughtworks.webdriven.commands.NoOp;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsVisible;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsSomethingSelected;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsEditable;
import org.openqa.selenium.thoughtworks.webdriven.commands.MetaKeyDown;
import org.openqa.selenium.thoughtworks.webdriven.commands.AltKeyUp;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetElementWidth;
import org.openqa.selenium.thoughtworks.webdriven.commands.AlertOverride;
import org.openqa.selenium.thoughtworks.webdriven.commands.AddLocationStrategy;
import org.openqa.selenium.thoughtworks.webdriven.commands.RemoveSelection;
import org.openqa.selenium.thoughtworks.webdriven.commands.SetNextConfirmationState;
import org.openqa.selenium.thoughtworks.webdriven.commands.FindSelectedOptionProperties;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetElementPositionTop;
import org.openqa.selenium.thoughtworks.webdriven.commands.KeyUpNative;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetCssCount;
import org.openqa.selenium.thoughtworks.webdriven.commands.CreateCookie;
import org.openqa.selenium.thoughtworks.webdriven.commands.ShiftKeyUp;
import org.openqa.selenium.thoughtworks.webdriven.commands.Highlight;
import org.openqa.selenium.thoughtworks.webdriven.commands.CaptureScreenshotToString;
import org.openqa.selenium.thoughtworks.webdriven.commands.FireEvent;
import org.openqa.selenium.thoughtworks.webdriven.commands.AddSelection;
import org.openqa.selenium.thoughtworks.webdriven.commands.DragAndDrop;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetExpression;
import org.openqa.selenium.thoughtworks.webdriven.commands.SetTimeout;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAllWindowNames;
import org.openqa.selenium.thoughtworks.webdriven.commands.SelectOption;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetLocation;
import org.openqa.selenium.thoughtworks.webdriven.commands.UseXPathLibrary;
import org.openqa.selenium.thoughtworks.webdriven.commands.ShiftKeyDown;
import org.openqa.selenium.thoughtworks.webdriven.commands.Open;
import org.openqa.selenium.thoughtworks.webdriven.commands.ControlKeyDown;
import org.openqa.selenium.thoughtworks.webdriven.commands.WaitForPageToLoad;
import org.openqa.selenium.thoughtworks.webdriven.commands.Type;
import org.openqa.selenium.thoughtworks.webdriven.commands.Click;
import org.openqa.selenium.thoughtworks.webdriven.commands.WaitForPopup;
import org.openqa.selenium.thoughtworks.webdriven.commands.Submit;
import org.openqa.selenium.thoughtworks.webdriven.commands.RemoveAllSelections;
import org.openqa.selenium.thoughtworks.webdriven.commands.KeyDownNative;
import org.openqa.selenium.thoughtworks.webdriven.commands.OpenWindow;
import org.openqa.selenium.thoughtworks.webdriven.commands.WindowFocus;
import org.openqa.selenium.thoughtworks.webdriven.commands.AssignId;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetElementPositionLeft;
import org.openqa.selenium.thoughtworks.webdriven.commands.TypeKeys;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsChecked;
import org.openqa.selenium.thoughtworks.webdriven.commands.Check;
import org.openqa.selenium.thoughtworks.webdriven.commands.Close;
import org.openqa.selenium.thoughtworks.webdriven.commands.WaitForCondition;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsCookiePresent;
import org.openqa.selenium.thoughtworks.webdriven.commands.AllowNativeXPath;
import org.openqa.selenium.thoughtworks.webdriven.commands.SelectPopUp;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetXpathCount;
import org.openqa.selenium.thoughtworks.webdriven.commands.MetaKeyUp;
import org.openqa.selenium.thoughtworks.webdriven.commands.ControlKeyUp;
import org.openqa.selenium.thoughtworks.webdriven.commands.DragAndDropToObject;
import org.openqa.selenium.thoughtworks.webdriven.commands.ClickAt;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAllFields;
import org.openqa.selenium.thoughtworks.webdriven.commands.SelectFrame;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsConfirmationPresent;
import org.openqa.selenium.thoughtworks.webdriven.commands.AttachFile;
import org.openqa.selenium.thoughtworks.webdriven.commands.Uncheck;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsTextPresent;
import org.openqa.selenium.thoughtworks.webdriven.commands.FindFirstSelectedOptionProperty;
import org.openqa.selenium.thoughtworks.webdriven.commands.MouseEventAt;
import org.openqa.selenium.thoughtworks.webdriven.commands.FireNamedEvent;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetCookieByName;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetSelectOptions;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetTable;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetAlert;
import org.openqa.selenium.thoughtworks.webdriven.commands.RunScript;
import org.openqa.selenium.thoughtworks.webdriven.commands.GetCookie;
import org.openqa.selenium.thoughtworks.webdriven.commands.IsOrdered;
import org.openqa.selenium.thoughtworks.webdriven.commands.DeleteAllVisibleCookies;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;

import org.openqa.selenium.thoughtworks.CommandProcessor;
import org.openqa.selenium.thoughtworks.SeleniumException;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.WrapsDriver;

import java.util.Map;


/**
 * A CommandProcessor which delegates commands down to an underlying webdriver instance.
 */
public class WebDriverCommandProcessor implements CommandProcessor, WrapsDriver {

  private final Map<String, SeleneseCommand<?>> seleneseMethods = Maps.newHashMap();
  private final String baseUrl;
  private final Timer timer;
  private final CompoundMutator scriptMutator;
  private boolean enableAlertOverrides = true;
  private Supplier<WebDriver> maker;
  private WebDriver driver;

  public WebDriverCommandProcessor(String baseUrl, WebDriver driver) {
    this(baseUrl, new ExplodingSupplier());
    this.driver = driver;

    assertDriverSupportsJavascript(driver);

    setUpMethodMap();
  }

  public WebDriverCommandProcessor(String baseUrl, Supplier<WebDriver> maker) {
    this.maker = maker;
    this.baseUrl = baseUrl;
    this.timer = new Timer(30000);
    this.scriptMutator = new CompoundMutator(baseUrl);
  }

  public WebDriver getWrappedDriver() {
    return driver;
  }

  public String getRemoteControlServerLocation() {
    throw new UnsupportedOperationException();
  }

  public String doCommand(String commandName, String[] args) {
    Object val = execute(commandName, args);
    if (val == null) {
      return null;
    }

    return val.toString();
  }

  public void setExtensionJs(String s) {
    throw new UnsupportedOperationException();
  }

  public void start() {
    start((Object) null);
  }

  public void start(String s) {
    throw new UnsupportedOperationException("Unsure how to process: " + s);
  }

  public void start(Object o) {
    if (driver != null) {
      if (maker != null) {
        throw new SeleniumException("You may not start more than one session at a time");
      } else {
        // The command processor was instantiated with an already started driver
        return;
      }
    }

    driver = maker.get();

    assertDriverSupportsJavascript(driver);

    setUpMethodMap();
  }

  public void stop() {
    timer.stop();
    if (driver != null) {
      driver.quit();
    }
    driver = null;
  }

  public String getString(String commandName, String[] args) {
    return (String) execute(commandName, args);
  }

  public String[] getStringArray(String commandName, String[] args) {
    return (String[]) execute(commandName, args);
  }

  public Number getNumber(String commandName, String[] args) {
    return (Number) execute(commandName, args);
  }

  public Number[] getNumberArray(String s, String[] strings) {
    throw new UnsupportedOperationException();
  }

  public boolean getBoolean(String commandName, String[] args) {
    return (Boolean) execute(commandName, args);
  }

  public boolean[] getBooleanArray(String s, String[] strings) {
    throw new UnsupportedOperationException();
  }

  private Object execute(String commandName, final String[] args) {
    final SeleneseCommand<?> command = seleneseMethods.get(commandName);
    if (command == null) {
      throw new UnsupportedOperationException(commandName);
    }

    return timer.run(command, driver, args);
  }

  public void addMutator(ScriptMutator mutator) {
    scriptMutator.addMutator(mutator);
  }

  public boolean isMethodAvailable(String methodName) {
    return seleneseMethods.containsKey(methodName);
  }

  public void addMethod(String methodName, SeleneseCommand<?> command) {
    seleneseMethods.put(methodName, command);
  }

  public SeleneseCommand<?> getMethod(String methodName) {
    return seleneseMethods.get(methodName);
  }

  @VisibleForTesting
  protected void assertDriverSupportsJavascript(WebDriver driver) {
    if (!(driver instanceof JavascriptExecutor)) {
      throw new IllegalStateException("Driver instance must support JS.");
    }

    if (!(driver instanceof HasCapabilities)) {
      // Might be proxy. Bail.
      return;
    }

    if (!((HasCapabilities) driver).getCapabilities().isJavascriptEnabled()) {
      throw new IllegalStateException("JS support must be enabled.");
    }
  }

  /**
   * Sets whether to enable emulation of Selenium's alert handling functions or
   * to preserve WebDriver's alert handling. This has no affect after calling
   * {@link #start()}.
   *
   * @param enableAlertOverrides boolean to enable overrides
   */
  public void setEnableAlertOverrides(boolean enableAlertOverrides) {
    this.enableAlertOverrides = enableAlertOverrides;
  }

  private void setUpMethodMap() {
    JavascriptLibrary javascriptLibrary = new JavascriptLibrary();
    ElementFinder elementFinder = new ElementFinder(javascriptLibrary);
    KeyState keyState = new KeyState();

    AlertOverride alertOverride = new AlertOverride(enableAlertOverrides);
    Windows windows = new Windows(driver);

    // Note the we use the names used by the CommandProcessor
    seleneseMethods.put("addLocationStrategy", new AddLocationStrategy(elementFinder));
    seleneseMethods.put("addSelection", new AddSelection(javascriptLibrary, elementFinder));
    seleneseMethods.put("allowNativeXpath", new AllowNativeXPath());
    seleneseMethods.put("altKeyDown", new AltKeyDown(keyState));
    seleneseMethods.put("altKeyUp", new AltKeyUp(keyState));
    seleneseMethods.put("assignId", new AssignId(javascriptLibrary, elementFinder));
    seleneseMethods.put("attachFile", new AttachFile(elementFinder));
    seleneseMethods.put("captureScreenshotToString", new CaptureScreenshotToString());
    seleneseMethods.put("click", new Click(alertOverride, elementFinder));
    seleneseMethods.put("clickAt", new ClickAt(alertOverride, elementFinder));
    seleneseMethods.put("check", new Check(alertOverride, elementFinder));
    seleneseMethods.put("chooseCancelOnNextConfirmation", new SetNextConfirmationState(false));
    seleneseMethods.put("chooseOkOnNextConfirmation", new SetNextConfirmationState(true));
    seleneseMethods.put("close", new Close());
    seleneseMethods.put("createCookie", new CreateCookie());
    seleneseMethods.put("controlKeyDown", new ControlKeyDown(keyState));
    seleneseMethods.put("controlKeyUp", new ControlKeyUp(keyState));
    seleneseMethods.put("deleteAllVisibleCookies", new DeleteAllVisibleCookies());
    seleneseMethods.put("deleteCookie", new DeleteCookie());
    seleneseMethods.put("deselectPopUp", new DeselectPopUp(windows));
    seleneseMethods.put("doubleClick", new DoubleClick(alertOverride, elementFinder));
    seleneseMethods.put("dragdrop", new DragAndDrop(elementFinder));
    seleneseMethods.put("dragAndDrop", new DragAndDrop(elementFinder));
    seleneseMethods.put("dragAndDropToObject", new DragAndDropToObject(elementFinder));
    seleneseMethods.put("fireEvent", new FireEvent(elementFinder, javascriptLibrary));
    seleneseMethods.put("focus", new FireNamedEvent(elementFinder, javascriptLibrary, "focus"));
    seleneseMethods.put("getAlert", new GetAlert(alertOverride));
    seleneseMethods.put("getAllButtons", new GetAllButtons());
    seleneseMethods.put("getAllFields", new GetAllFields());
    seleneseMethods.put("getAllLinks", new GetAllLinks());
    seleneseMethods.put("getAllWindowNames", new GetAllWindowNames());
    seleneseMethods.put("getAllWindowTitles", new GetAllWindowTitles());
    seleneseMethods.put("getAttribute", new GetAttribute(javascriptLibrary, elementFinder));
    seleneseMethods.put("getAttributeFromAllWindows", new GetAttributeFromAllWindows());
    seleneseMethods.put("getBodyText", new GetBodyText());
    seleneseMethods.put("getConfirmation", new GetConfirmation(alertOverride));
    seleneseMethods.put("getCookie", new GetCookie());
    seleneseMethods.put("getCookieByName", new GetCookieByName());
    seleneseMethods.put("getElementHeight", new GetElementHeight(elementFinder));
    seleneseMethods.put("getElementIndex", new GetElementIndex(elementFinder,
        javascriptLibrary));
    seleneseMethods.put("getElementPositionLeft", new GetElementPositionLeft(elementFinder));
    seleneseMethods.put("getElementPositionTop", new GetElementPositionTop(elementFinder));
    seleneseMethods.put("getElementWidth", new GetElementWidth(elementFinder));
    seleneseMethods.put("getEval", new GetEval(scriptMutator));
    seleneseMethods.put("getExpression", new GetExpression());
    seleneseMethods.put("getHtmlSource", new GetHtmlSource());
    seleneseMethods.put("getLocation", new GetLocation());
    seleneseMethods.put("getSelectedId", new FindFirstSelectedOptionProperty(javascriptLibrary,
        elementFinder, "id"));
    seleneseMethods.put("getSelectedIds", new FindSelectedOptionProperties(javascriptLibrary,
        elementFinder, "id"));
    seleneseMethods.put("getSelectedIndex", new FindFirstSelectedOptionProperty(javascriptLibrary,
        elementFinder, "index"));
    seleneseMethods.put("getSelectedIndexes", new FindSelectedOptionProperties(javascriptLibrary,
        elementFinder, "index"));
    seleneseMethods.put("getSelectedLabel", new FindFirstSelectedOptionProperty(javascriptLibrary,
        elementFinder, "text"));
    seleneseMethods.put("getSelectedLabels", new FindSelectedOptionProperties(javascriptLibrary,
        elementFinder, "text"));
    seleneseMethods.put("getSelectedValue", new FindFirstSelectedOptionProperty(javascriptLibrary,
        elementFinder, "value"));
    seleneseMethods.put("getSelectedValues", new FindSelectedOptionProperties(javascriptLibrary,
        elementFinder, "value"));
    seleneseMethods.put("getSelectOptions", new GetSelectOptions(javascriptLibrary, elementFinder));
    seleneseMethods.put("getSpeed", new NoOp("0"));
    seleneseMethods.put("getTable", new GetTable(elementFinder, javascriptLibrary));
    seleneseMethods.put("getText", new GetText(javascriptLibrary, elementFinder));
    seleneseMethods.put("getTitle", new GetTitle());
    seleneseMethods.put("getValue", new GetValue(elementFinder));
    seleneseMethods.put("getXpathCount", new GetXpathCount());
    seleneseMethods.put("getCssCount", new GetCssCount());
    seleneseMethods.put("goBack", new GoBack());
    seleneseMethods.put("highlight", new Highlight(elementFinder, javascriptLibrary));
    seleneseMethods.put("isAlertPresent", new IsAlertPresent(alertOverride));
    seleneseMethods.put("isChecked", new IsChecked(elementFinder));
    seleneseMethods.put("isConfirmationPresent", new IsConfirmationPresent(alertOverride));
    seleneseMethods.put("isCookiePresent", new IsCookiePresent());
    seleneseMethods.put("isEditable", new IsEditable(elementFinder));
    seleneseMethods.put("isElementPresent", new IsElementPresent(elementFinder));
    seleneseMethods.put("isOrdered", new IsOrdered(elementFinder, javascriptLibrary));
    seleneseMethods.put("isSomethingSelected", new IsSomethingSelected(javascriptLibrary));
    seleneseMethods.put("isTextPresent", new IsTextPresent(javascriptLibrary));
    seleneseMethods.put("isVisible", new IsVisible(elementFinder));
    seleneseMethods.put("keyDown", new KeyEvent(elementFinder, javascriptLibrary, keyState,
        "doKeyDown"));
    seleneseMethods.put("keyDownNative", new KeyDownNative());
    seleneseMethods.put("keyPress", new TypeKeys(alertOverride, elementFinder));
    seleneseMethods.put("keyPressNative", new KeyPressNative());
    seleneseMethods.put("keyUp",
        new KeyEvent(elementFinder, javascriptLibrary, keyState, "doKeyUp"));
    seleneseMethods.put("keyUpNative", new KeyUpNative());
    seleneseMethods.put("metaKeyDown", new MetaKeyDown(keyState));
    seleneseMethods.put("metaKeyUp", new MetaKeyUp(keyState));
    seleneseMethods.put("mouseOver", new MouseEvent(elementFinder, javascriptLibrary, "mouseover"));
    seleneseMethods.put("mouseOut", new MouseEvent(elementFinder, javascriptLibrary, "mouseout"));
    seleneseMethods.put("mouseDown", new MouseEvent(elementFinder, javascriptLibrary, "mousedown"));
    seleneseMethods.put("mouseDownAt", new MouseEventAt(elementFinder, javascriptLibrary,
        "mousedown"));
    seleneseMethods.put("mouseMove", new MouseEvent(elementFinder, javascriptLibrary, "mousemove"));
    seleneseMethods.put("mouseMoveAt", new MouseEventAt(elementFinder, javascriptLibrary,
        "mousemove"));
    seleneseMethods.put("mouseUp", new MouseEvent(elementFinder, javascriptLibrary, "mouseup"));
    seleneseMethods.put("mouseUpAt", new MouseEventAt(elementFinder, javascriptLibrary, "mouseup"));
    seleneseMethods.put("open", new Open(baseUrl));
    seleneseMethods.put("openWindow", new OpenWindow(baseUrl, new GetEval(scriptMutator)));
    seleneseMethods.put("refresh", new Refresh());
    seleneseMethods.put("removeAllSelections", new RemoveAllSelections(elementFinder));
    seleneseMethods.put("removeSelection", new RemoveSelection(javascriptLibrary, elementFinder));
    seleneseMethods.put("runScript", new RunScript(scriptMutator));
    seleneseMethods.put("select",
        new SelectOption(alertOverride, javascriptLibrary, elementFinder));
    seleneseMethods.put("selectFrame", new SelectFrame(windows));
    seleneseMethods.put("selectPopUp", new SelectPopUp(windows));
    seleneseMethods.put("selectWindow", new SelectWindow(windows));
    seleneseMethods.put("setBrowserLogLevel", new NoOp(null));
    seleneseMethods.put("setContext", new NoOp(null));
    seleneseMethods.put("setSpeed", new NoOp(null));
    seleneseMethods.put("setTimeout", new SetTimeout(timer));
    seleneseMethods.put("shiftKeyDown", new ShiftKeyDown(keyState));
    seleneseMethods.put("shiftKeyUp", new ShiftKeyUp(keyState));
    seleneseMethods.put("submit", new Submit(alertOverride, elementFinder));
    seleneseMethods.put("type",
        new Type(alertOverride, javascriptLibrary, elementFinder, keyState));
    seleneseMethods.put("typeKeys", new TypeKeys(alertOverride, elementFinder));
    seleneseMethods.put("uncheck", new Uncheck(alertOverride, elementFinder));
    seleneseMethods.put("useXpathLibrary", new UseXPathLibrary());
    seleneseMethods.put("waitForCondition", new WaitForCondition(scriptMutator));
    seleneseMethods.put("waitForFrameToLoad", new NoOp(null));
    seleneseMethods.put("waitForPageToLoad", new WaitForPageToLoad());
    seleneseMethods.put("waitForPopUp", new WaitForPopup(windows));
    seleneseMethods.put("windowFocus", new WindowFocus(javascriptLibrary));
    seleneseMethods.put("windowMaximize", new WindowMaximize(javascriptLibrary));
  }
}
