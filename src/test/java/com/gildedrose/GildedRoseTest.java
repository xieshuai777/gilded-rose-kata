package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test that the quality of Aged Bri is good")
  void testQuality1() {
    Item element = new Item("Aged Brie", 5, 48);
    GildedRose app = new GildedRose(new Item[]{element});
    Item element2 = new Item("Aged Brie", 0, 48);
    GildedRose app2 = new GildedRose(new Item[]{element2});
    app.updateQuality();
    assertThat(element.quality, is(49));
    app.updateQuality();
    assertThat(element.quality, is(50));
    for(int i = 0; i<3; i++) {
      app.updateQuality();
    }
    assertThat(element.quality, is(50));
    app.updateQuality();
    assertThat(element.quality, is(50));
    app2.updateQuality();
    assertThat(element2.quality, is(50));
  }

  @Test
  @DisplayName("Test that the quality of Backstage passes is good")
  void testQuality2() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 43);
    GildedRose app = new GildedRose(new Item[]{element});
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 46);
    GildedRose app2 = new GildedRose(new Item[]{element2});
    Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);
    GildedRose app3 = new GildedRose(new Item[]{element3});
    app.updateQuality();
    assertThat(element.quality, is(45));
    app.updateQuality();
    assertThat(element.quality, is(48));
    app.updateQuality();
    assertThat(element.quality, is(50));
    app.updateQuality();
    assertThat(element.quality, is(50));
    app.updateQuality();
    assertThat(element.quality, is(50));
    app.updateQuality();
    assertThat(element.quality, is(50));
    app.updateQuality();
    assertThat(element.quality, is(0));
    app2.updateQuality();
    assertThat(element2.quality, is(47));
    app2.updateQuality();
    assertThat(element2.quality, is(49));
    app2.updateQuality();
    assertThat(element2.quality, is(50));
    app2.updateQuality();
    assertThat(element2.quality, is(50));
    app3.updateQuality();
    assertThat(element3.quality, is(50));

  }

  @Test
  @DisplayName("Test that the quality of sulfras is good")
  void testQuality3() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
    GildedRose app = new GildedRose(new Item[]{element});
    Item element2 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    GildedRose app2 = new GildedRose(new Item[]{element2});
    app.updateQuality();
    assertThat(element.quality, is(80));
    app.updateQuality();
    assertThat(element.quality, is(80));
    app2.updateQuality();
    assertThat(element2.quality, is(80));
  }

  @Test
  @DisplayName("Test that the quality is good")
  void testQuality4() {
    Item element = new Item("toto", 1, 5);
    GildedRose app = new GildedRose(new Item[]{element});
    app.updateQuality();
    assertThat(element.quality, is(4));
    app.updateQuality();
    assertThat(element.quality, is(2));
    app.updateQuality();
    assertThat(element.quality, is(0));
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that the SellIN is good")
  void testSellIn() {
    Item element = new Item("foo", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(0));
    app.updateQuality();
    assertThat(element.sellIn, is(-1));
  }
}
