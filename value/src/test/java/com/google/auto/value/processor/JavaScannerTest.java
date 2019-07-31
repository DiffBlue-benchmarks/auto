package com.google.auto.value.processor;

import org.junit.Assert;
import org.junit.Test;

public class JavaScannerTest {

  @Test
  public void testTokenEnd() {
    Assert.assertEquals(7, new JavaScanner("foobar").tokenEnd(11));
    Assert.assertEquals(4, new JavaScanner("   ").tokenEnd(3));
    Assert.assertEquals(1, new JavaScanner("/foo").tokenEnd(0));
    Assert.assertEquals(1, new JavaScanner(".foo").tokenEnd(0));
    Assert.assertEquals(4, new JavaScanner("/**/").tokenEnd(0));
    Assert.assertEquals(9, new JavaScanner("`foo\\bar`").tokenEnd(0));
    Assert.assertEquals(2, new JavaScanner("//").tokenEnd(0));
  }
}